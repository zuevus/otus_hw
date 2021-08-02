package ru.otus;

import java.io.IOException;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Breed {
    //private final Path CURRENT_DIR = Paths.get(System.getProperty("user.dir"));
    //private final Path JSON_FILE_PATH = Paths.get(CURRENT_DIR.toString(),"resources", "breeds.json");
    private List<Gait> gaits = new ArrayList<>(List.of(new Gait("walk", 7),
            new Gait("trot", 13),
            new Gait("canter", 20),
            new Gait("gallop", 40)));
    private final int max_speed = 0;
    private String breed_name = new String();
    private int hight = 0;
    private int speed = 0;
    private int best_gait = 0;
    private char[] json_content = new char[1000];

    public List<Gait> getGaits() {
        return gaits;
    }

    public Breed(String breedname) {
        this.breed_name = breedname.toUpperCase(Locale.ROOT);

    }
//    void Breed(String breedname, int maxspeed, int hight, best_gait) {
//        this.breed_name = breedname;
//        this.max_speed = maxspeed;
//        this.hight = hight;
//        this.hight = hight;
//
//
//
//    }



}
