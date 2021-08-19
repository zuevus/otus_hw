package ru.otus;

public interface DemoInterface {

    @Log
    void powerOf (double number, int power);

    void addition (double number1, double number2);

    @Log
    void subtraction (double number1, double number2);
}
