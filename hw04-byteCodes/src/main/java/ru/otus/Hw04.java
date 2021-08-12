package ru.otus;


public class Hw04 {
    public static void main(String... args) {
        DemoInterface demo_log = TestLogging.createDemoClass();
        demo_log.powerOf (5, 2);
        demo_log.addition(5, 2);
        demo_log.subtraction(5, 2);
    }
    //ToDO: (1 hour 08/11,1 hour 08/12) implement and integrate log annotation for get a func for logging ;  aop logging the func
}

