package ru.otus;

import java.util.Optional;

import static java.lang.Math.pow;

public class Demo implements DemoInterface {

    @Override
    public void powerOf(double base, int exp) {
        System.out.printf("%s in the %s Power is %s", base, name_of_powers(exp), pow(base,exp));
    }

    @Override
    public void addition(double number1, double number2) {
        System.out.printf("%s plus %s is %s", number1, number2, number1 + number2);
    }

    @Override
    public void subtraction(double number1, double number2) {
        System.out.printf("%s minus %s is %s", number1, number2, number1 - number2);
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
        return "Demo{}";
    }
}
