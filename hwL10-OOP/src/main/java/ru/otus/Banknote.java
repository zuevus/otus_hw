package ru.otus;

import java.util.Arrays;
import java.util.Random;

public class Banknote {
    private final String DEFAULT_CURRENCY = "RUR";
    private final int DEFAULT_SN_LENGTH = 20;
    private final String SN;

    public Banknote(int nominal) {
        SN = GenerateSN();
    }
    public String getSN() {
        return SN;
    }

    private String GenerateSN() {
        String snCollect = "";
        for (int i=0; i < DEFAULT_SN_LENGTH; i++) {
            double rand_int = Math.random();
            if ((rand_int * 1000) > 300) {
                snCollect += Long.toString(Math.round(rand_int * 10));
            } else {
                int char_num = (int) (Math.round(Math.abs(Math.random() * 100 - 90d)) + 65);
                System.out.println(char_num);
                snCollect += Character.toString(char_num);
            }
        }
        return snCollect;
        //if (Math.random() > 500)
        //char
    }
}
