package ru.otus;

import myjunit.MyTRTest;
//import org.junit.Test;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class MyTests {

    private List<Breed> breeds = new ArrayList<>(List.of(new Breed("Arabian"),
            new Breed("Friesian")));

    private List<Horse> horses = new ArrayList<>();


  //  @BeforeAll
   // void initialization() {
  //      System.out.println("Before all");
  //  }

    @MyTRTest
    public void checkGenderTC1() {
        try {
            horses.add(new Horse("Lolly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    15.0));
            horses.add(new Horse("Polly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    10.0));
            horses.add(new Horse("Molly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    3.0));
            horses.add(new Horse("Rich",
                    breeds.get(0),
                    new Sex("MALE"),
                    2.0));
            horses.add(new Horse("Lich",
                    breeds.get(0),
                    new Sex("MALE"),
                    10.0));
            horses.add(new Horse("Kinch",
                    breeds.get(0),
                    new Sex("MALE"),
                    31d));
        } catch (Exception exc) {
            System.out.println(exc);
        }
        assertEquals( "FEMALE", horses.get(0).getSex().getGender());
        assertNotEquals( "MALE", horses.get(0).getSex().getGender());
    }

    @MyTRTest
    public void checkAgesTC2() {
        try {
            horses.add(new Horse("Lolly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    15.0));
            horses.add(new Horse("Polly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    10.0));
            horses.add(new Horse("Molly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    3.0));
            horses.add(new Horse("Rich",
                    breeds.get(0),
                    new Sex("MALE"),
                    2.0));
            horses.add(new Horse("Lich",
                    breeds.get(0),
                    new Sex("MALE"),
                    10.0));
            horses.add(new Horse("Kinch",
                    breeds.get(0),
                    new Sex("MALE"),
                    31d));
        } catch (Exception exc) {
            System.out.println(exc);
        }

        assertEquals("MARE", horses.get(1).getGender());
        assertEquals("FILLY", horses.get(2).getGender());
        assertEquals("COLT", horses.get(3).getGender());
        assertEquals("STALLION", horses.get(4).getGender());
        assertEquals("TAXIDERMY", horses.get(5).getGender());
        assertNotEquals("MALE", horses.get(2).getSex().getGender());

    }

    @MyTRTest
    public void checkHorseNameTC3() {
        try {
            horses.add(new Horse("Lolly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    15.0));
            horses.add(new Horse("Polly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    10.0));
            horses.add(new Horse("Molly",
                    breeds.get(0),
                    new Sex("FEMALE"),
                    3.0));
            horses.add(new Horse("Rich",
                    breeds.get(0),
                    new Sex("MALE"),
                    2.0));
            horses.add(new Horse("Lich",
                    breeds.get(0),
                    new Sex("MALE"),
                    10.0));
            horses.add(new Horse("Kinch",
                    breeds.get(0),
                    new Sex("MALE"),
                    31d));
        } catch (Exception exc) {
            System.out.println(exc);
        }
        List<String> names = new ArrayList<>(List.of("Lolly", "Pollwy", "Molly", "Rich", "Lich"));
        int i = 0;
        for (String name : names) {
            assertEquals(name, horses.get(i).getName());
            i++;
        }
        assertNotEquals("Kich", horses.get(5).getName());

    }

//    @AfterAll
//    void tearDownAll() {
//        horses.clear();
//        System.out.println("After all");
//    }

}
