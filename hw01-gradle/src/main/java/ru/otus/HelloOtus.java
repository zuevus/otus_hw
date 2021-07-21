package ru.otus;

import java.util.ArrayList;
import java.util.List;

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
        int[] l = new int[10];
        List<Integer> example = new ArrayList<>();
        l[0] = 123;
        l[2] = 125;
        System.out.println(String.format("Lists: %s %s",example, l));
        int min = 0;
        int max = 100;
        for (int i = min; i < max; i++) {
            example.add(i);
        }
        System.out.println(String.format("Original list: %s",example));
        System.out.println(String.format("Reversed list: %s",Lists.reverse(example)));
    }

    public String buildMessage(int a, int b) {
        return String.format("Is %d form %d", a,b);
    }
}

