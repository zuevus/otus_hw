package ru.otus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;



/**
 *
 * To start the application:
 * ./gradlew build
 * java -jar ./hw01-gradle/build/libs/hw01-gradle.jar
 *
 * To unzip the jar:
 * unzip -l L01-gradle.jar
 * unzip -l gradleHelloWorld-0.1.jar
 *
 */
public class HelloOtus {
    public static void main(String... args) {

        List<Integer> example = new ArrayList<>();
        for (int i = 0; i < 100; i++) example.add(i);
        System.out.println(String.format("Original list: %s",example));
        System.out.println(reverse_list(example));

        List<Breed> breeds = new ArrayList<>(List.of(new Breed("Arabian"),
                new Breed("Friesian")));

        GenderType gType = new GenderType();
        Sex fa = new Sex(gType.female);
        Sex ma = new Sex(gType.male);

        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Lolly",
                breeds.get(0),
                fa,
               15.0));
        horses.add(new Horse("Polly",
                breeds.get(1),
                fa,
                10.0));
        horses.add(new Horse("Molly",
                breeds.get(0),
                fa,
                3.0));
        horses.add(new Horse("Dolly",
                breeds.get(1),
                fa,
                3.0));


        //gaits.add(new Gait("walk", 7));
        //gaits.add(new Gait("trot", 13));
        //gaits.add(new Gait("canter", 20));
        //gaits.add(new Gait("gallop", 40));
        System.out.println(horses);

//
//        Breed new_breed = new Breed()
    }

    private static String reverse_list(List<Integer>  input_list) {
        return String.format("Reversed list: %s",Lists.reverse(input_list));
    }
}

