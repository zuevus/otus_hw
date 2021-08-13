package ru.otus;


public class Hw04 {
    public static void main(String... args) {
        //Test with first Demo
        DemoInterface demo_obj = new Demo();
        demo_obj.powerOf (7, 3);
        demo_obj.addition(3, 3);
        demo_obj.subtraction(6, 89);
        DemoInterface demo_log = (DemoInterface) TestLogging.createDemoClass(demo_obj);
        demo_log.powerOf (5, 2);
        demo_log.addition(5, 2);
        demo_log.subtraction(5, 2);

        //Test with second Demo
        Demo2Interface demo_obj_2 = new Demo2();
        demo_obj_2.logarithmBase10(10000);
        demo_obj_2.multiplication (3, 8, 7, 8, 2, 4);
        Demo2Interface demo_log_2 = (Demo2Interface) TestLogging.createDemoClass(demo_obj_2);
        demo_log_2.logarithmBase10(1000);
        demo_log_2.multiplication (5, 2, 5, 3, 4, 2);

    }
    //ToDO:
    // - V(1 hour 08/11,1 hour 08/12) implement and integrate log annotation for get a func for logging ;  aop logging the func
    // - V(1 hour 08/13) make the createDemoClass func more universal (add argument which will represent any class for logging)
}

