package ru.otus;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Horse implements RideAHorse {

    private String name = new String();
    //private Breed breed = new Breed();
    private int currentGate = 0;
    private Breed horseBreed;
    private Sex gender;
    private double age;


    Horse (String name, Breed breed, Sex gender, Double age) {
        this.name = name;
        this.horseBreed = breed;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getCurrentSpeed() {
        return horseBreed.getGaits().get(currentGate).getMiddleSpeed("k");
    }

    public int changeGait() {
        currentGate = (horseBreed.getGaits().size() < currentGate) ? currentGate + 1 : 0;
        return currentGate;
    }

    public String getGender() {
        return gender.getSex(age);
    }

    public Sex getSex() {
        return gender;
    }

    public Breed getHorseBreed() {
        return horseBreed;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getCurrentGate() {
        return currentGate;
    }

    @Override
    public String toString() {
        return String.format("Horse name: %s; Horse age: %s; Current gate: %s; Current speed: %s",
                name,
                age,
                horseBreed.getGaits().get(getCurrentGate()),
                getCurrentSpeed());
    }

}
