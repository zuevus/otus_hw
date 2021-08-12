package ru.otus;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestLogging {

    private TestLogging() {}

    static DemoInterface createDemoClass() {
        Class<?> wrapped_class = Demo.class;
        Class<?> wrapped_interface_class = wrapped_class.getInterfaces()[0];

        Stream<Method> annotated_methods;
        annotated_methods = Arrays
                .stream(wrapped_interface_class.getMethods())
                .filter(m -> m.isAnnotationPresent(Log.class));
        //annotated_methods.forEach(m -> System.out.printf("Found a method for logging: %s\n", m.getName()));
        //Variant A
        InvocationHandler handler = new DemoInvocationHandler(new Demo(), annotated_methods.toArray(Method[]::new));
        //Variant B
        //InvocationHandler handler = new DemoInvocationHandler(new Demo(), annotated_methods);
        return (DemoInterface) Proxy.newProxyInstance(TestLogging.class.getClassLoader(),
                new Class<?>[]{wrapped_interface_class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final DemoInterface myClass;
        private final Method[] modify_methods; //Stream<Method> modify_methods | Method[]

        DemoInvocationHandler(DemoInterface myClass, Method[] modify_methods) { //Stream<Method> modify_methods | Method[]
            this.myClass = myClass;
            this.modify_methods = modify_methods;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //Variant A
            if (Arrays.asList(this.modify_methods).contains(method)) {
            //Variant B
            //if (this.modify_methods.anyMatch(m -> m.equals(method))) {
                System.out.printf("Executed method: %s;\n",
                        method.getName()
                );
                //Parameter[] parameters = myClass.getClass().getMethod(method.toString()).getParameters();
                //System.out.printf("Method params: %s",
                 //       Arrays.toString(parameters));
                System.out.printf("Parameters: %s\n",
                        String.join(", ", Arrays.stream(args)
                                .map(a -> String.format("%s <%s>",
                                        a.toString(),
                                        a.getClass().getName())).toArray(String[]::new)
                        )
                );

            }
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + myClass +
                    '}';
        }
    }
}
