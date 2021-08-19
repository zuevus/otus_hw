package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

public class TestLogging {

    private TestLogging() {}

    static Object createDemoClass(Object obj) {
        Class<?> wrapped_class = obj.getClass();
        Class<?> wrapped_interface_class = wrapped_class.getInterfaces()[0];

        Stream<Method> annotated_methods;
        annotated_methods = Arrays
                .stream(wrapped_interface_class.getMethods())
                .filter(m -> m.isAnnotationPresent(Log.class));

        InvocationHandler handler = new DemoInvocationHandler(obj, annotated_methods.toArray(Method[]::new));
        return Proxy.newProxyInstance(TestLogging.class.getClassLoader(),
                new Class<?>[]{wrapped_interface_class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final Object wrapped_obj;
        private final Method[] modify_methods;

        DemoInvocationHandler(Object wrapped_obj, Method[] modify_methods) {
            this.wrapped_obj = wrapped_obj;
            this.modify_methods = modify_methods;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (Set.of(this.modify_methods).contains(method)) {
                System.out.printf("\u001B[31mExecuted method: %s;\u001B[0m\n",
                        method.getName()
                );
                System.out.printf("\u001B[32m\tParameters: %s\u001B[0m\n",
                        String.join(", ", Arrays.stream(args)
                                .map(a -> String.format("%s <%s>",
                                        a.toString(),
                                        a.getClass().getName())).toArray(String[]::new)
                        )
                );

            }
            return method.invoke(wrapped_obj, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + wrapped_obj +
                    '}';
        }
    }
}
