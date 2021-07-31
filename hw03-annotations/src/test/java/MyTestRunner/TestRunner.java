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

    public static void main(String... args ) throws ClassNotFoundException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        if (args.length > 0) {
            String classname = args[0];

            Class<?> clazz = Class.forName(classname);

            Method[] methods = clazz.getMethods();

            //List because length is unknown
            List<Method> CMBefore = new ArrayList<>();
            List<Method> CMAfter = new ArrayList<>();
            List<Method> CMTests = new ArrayList<>();

            if (methods.length > 0) {
                for (Method method : methods) {
                    Annotation[] annotations = method.getDeclaredAnnotations();
                    if (annotations.length > 0) {
                        //Collect all Before annotation
                        if (annotations[0].toString().equals("@MyTestRunner.Before()")) {
                            CMBefore.add(method);
                        }
                        if (annotations[0].toString().equals("@MyTestRunner.After()")) {
                            CMAfter.add(method);
                        }
                        if (annotations[0].toString().equals("@MyTestRunner.Test()")) {
                            CMTests.add(method);
                        }
                    }
                }
            }

            if (CMTests.size() > 0) {
                for (Method test_method : CMTests) {
                    Instant pointInTime = Instant.now();
                    var self = clazz.getDeclaredConstructor().newInstance();
                    try {
                        if (CMBefore.size() > 0) {
                            for (Method before_method : CMBefore) {
                                System.out.printf("Before routine for the %s method has been run.\n",
                                        before_method.getName());
                                before_method.invoke(self);
                                System.out.printf("Before routine for the %s method has been finished.\n",
                                        before_method.getName());
                            }
                        }
                        System.out.printf("Test routine the %s method has been run!\n", test_method.getName());
                        test_method.invoke(self);
                        System.out.printf("Before routine has been finished: %s\n", test_method.getName());
                    } catch (Exception ext) {
                        System.out.printf("The test which provided by %s has been failed!\n The reason is: \n\t%s\n",
                                test_method.getName(), ext.getCause());
                    }
                    if (CMAfter.size() > 0) {
                        for (Method after_method : CMAfter) {
                            System.out.printf("Cleaning procedure provided by the %s has been started.\n", after_method.getName());
                            after_method.invoke(self);
                            System.out.printf("Cleaning procedure provided by the %s has been finished.\n", after_method.getName());
                        }
                    }
                    Duration test_time_execution = Duration.between(pointInTime, Instant.now());
                    System.out.printf("Period of the test execution is %s nsec\n",
                            test_time_execution.getNano());
                }
            }
        } else {
            System.out.println("Pass class name as the first argument!");
        }
    }

}
