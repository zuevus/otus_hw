package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class  Sex {
    private String[] genders = new String[]{"MALE", "FEMALE"};
    private List<String> particularities = new ArrayList<>();
    private String gender;
    private boolean castrated = false;



    Sex (String gender) throws Exception {
        if (gender.indexOf(gender) != -1) {
            this.gender = gender;
        }
        else {
            throw new Exception("Passed wrong gender as a parameter!");
        }
    }

    public String getGender() {
        return gender;
    }

    public String getSex(double age) {
        if (age < 4.0) {
            if (gender.equals("MALE")) {
                return "COLT";
            } else {
                return "FILLY";
            }
        } else {
            if (age < 30) {
                if (gender.equals("MALE")) {
                    if (!castrated) {
                        return "STALLION";
                    } else {
                        return "GELDING";
                    }
                } else {
                    return "MARE";
                }
            } else {
                return "TAXIDERMY";
            }
        }
    }
}
