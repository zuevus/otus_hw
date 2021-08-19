package ru.otus;

import java.util.Arrays;

import static java.lang.Math.log10;

public class Demo2 implements Demo2Interface {

    @Override
    public void multiplication (double... numbers){
        double result = 1;
        for (double number: numbers) {
            result *= number;
        }
        System.out.printf("Result of multiplication of the numbers %s is %s\n",
                String.join(" X ", Arrays.toString(numbers)), result);
    }

    @Override
    public void logarithmBase10(double number) {
        System.out.printf("The logarithm base 10 of %s is %s\n", number, log10(number));
    }

    private String name_of_powers (int power) {
        return switch (power) {
            case 0 -> "zero";
            case 1 -> "1st";
            case 2 -> "2nd";
            case 3 -> "3rd";
            default -> String.format("%sth", power);
        };
    }

    @Override
    public String toString() {
        return "Demo2{}";
    }
}
