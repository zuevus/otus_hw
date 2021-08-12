package ru.otus;

public interface DemoInterface {

    public String field1 = "One";
    public String field2 = "Two";

    @Log
    void powerOf (double number, int power);

    void addition (double number1, double number2);

    @Log
    void subtraction (double number1, double number2);
}
