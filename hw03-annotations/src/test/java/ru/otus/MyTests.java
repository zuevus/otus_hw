package ru.otus;



import MyTestRunner.AssertsCollection;

import java.util.ArrayList;
import java.util.List;

import static MyTestRunner.AssertsCollection.assertEquals;

public class MyTests {

    private final List<Breed> breeds = new ArrayList<>(List.of(new Breed("Arabian"),
            new Breed("Friesian")));

    private final List<Horse> horses = new ArrayList<>();

    private final GenderType gType = new GenderType();
    private final Sex female = new Sex(gType.female);
    private final Sex male = new Sex(gType.male);


    @MyTestRunner.Before
    public void init() {
        this.horses.addAll(List.of(
                new Horse("Lolly",
                        breeds.get(0),
                        female,
                        15.0),
                new Horse("Polly",
                        breeds.get(1),
                        female,
                        10.0),
                new Horse("Molly",
                        breeds.get(0),
                        female,
                        3.0),
                new Horse("Dolly",
                        breeds.get(1),
                        female,
                        3.0),
                new Horse("Rich",
                        breeds.get(1),
                        male,
                        2.0),
                new Horse("Lich",
                        breeds.get(0),
                        male,
                        10.0),
                new Horse("Kinch",
                        breeds.get(1),
                        male,
                        31d)));
        this.horses.forEach(h -> System.out.printf("The new horses added: %s\n", h));
   }

    @MyTestRunner.Test
    public void checkGenderTC1() throws Exception {
        assertEquals( "FEMALE", horses.get(0).getSex().getGender());
        //assertNotEquals( "MALE", horses.get(0).getSex().getGender());
    }

    @MyTestRunner.Test
    public void checkAgesTC2()  throws Exception {
        assertEquals("MARE", horses.get(1).getGender());
        assertEquals("FILLY", horses.get(2).getGender());
        assertEquals("COLT", horses.get(3).getGender());
        assertEquals("STALLION", horses.get(4).getGender());
        assertEquals("TAXIDERMY", horses.get(5).getGender());
        //assertNotEquals("MALE", horses.get(2).getSex().getGender());

    }

    @MyTestRunner.Test
    public void checkHorseNameTC3()  throws Exception {
        List<String> names = new ArrayList<>(List.of("Lolly", "Pollwy", "Molly", "Rich", "Lich"));
        int i = 0;
        for (String name : names) {
            assertEquals(name, horses.get(i).getName());
            i++;
        }
        //assertNotEquals("Kich", horses.get(5).getName());
    }

    @MyTestRunner.After
    public void finish() {
        System.out.println("The method after has been started...");
        horses.clear();
        System.out.println("The method after has been finished...");
    }

}
