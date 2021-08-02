package MyTestRunner;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.Instant;


public class TestRunner {

    public static void main(String... args ) throws Exception, ClassNotFoundException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        if (args.length > 0) {
            String classname = args[0];

            Class<?> clazz = Class.forName(classname);

            Method[] methods = clazz.getMethods();

            //List because length is unknown
            List<Method> CMBefore = collectAnnotations(methods,"@MyTestRunner.Before()");
            List<Method> CMAfter = collectAnnotations(methods, "@MyTestRunner.After()");
            List<Method> CMTests = collectAnnotations(methods, "@MyTestRunner.Test()");

            var self = clazz.getDeclaredConstructor().newInstance();
            Instant pointInTime = Instant.now();
            if (CMTests.size() > 0) {
                for (Method test_method : CMTests) {
                    try {
                        wrapAMethod(CMBefore, self, "initialization");
                        System.out.printf("The testing procedure provided by the %s has been started.\n!\n",
                                test_method.getName());
                        test_method.invoke(self);
                        System.out.printf("The testing procedure provided by the %s has been finished.\n",
                                test_method.getName());
                    } catch (Exception ext) {
                        System.out.printf("The test which provided by %s has been failed!\n The reason is: \n\t%s\n",
                                test_method.getName(), ext.getCause());
                    }
                    wrapAMethod(CMAfter, self, "finalization");
                }
            }
            Duration test_time_execution = Duration.between(pointInTime, Instant.now());
            System.out.printf("Period of the all test procedure execution is %s nsec\n",
                    test_time_execution.getNano());

        } else {
            System.out.println("Pass class name as the first argument!");
        }
    }

    private static List<Method> collectAnnotations(Method[] methods, String aClassName) throws Exception{
        List<Method> CollectionOfAMethods = new ArrayList<>();

        if (methods.length > 0) {
            for (Method method : methods) {
                Annotation[] annotations = method.getDeclaredAnnotations();

                if (annotations.length > 0) {
                    if (annotations[0].toString().equals(aClassName)) { CollectionOfAMethods.add(method); }
                }
            }
            return CollectionOfAMethods;
        } else {
            throw new Exception("Methods don't exists");
        }
    }

    //private static void startTesting(List<Method> methods, String aClassName) throws Exception{

   // }

    private static boolean wrapAMethod(List<Method> methods, Object self, String procedure) throws Exception{

        if (methods.size() > 0) {
            for (Method test_method : methods) {
                Instant pointInTime = Instant.now();

                System.out.printf("The %s procedure provided by the %s has been started.\n",
                        procedure, test_method.getName());
                test_method.invoke(self);
                System.out.printf("The %s procedure provided by the %s has been finished.\n",
                        procedure, test_method.getName());

                Duration test_time_execution = Duration.between(pointInTime, Instant.now());
                System.out.printf("Period of the %s method execution is %s nsec\n",
                        test_method.getName(), test_time_execution.getNano());
            }
            return true;
        } else {
            return false;
        }

    }

}
