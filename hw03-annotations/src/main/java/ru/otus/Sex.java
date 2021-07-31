package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class  Sex {
    private List<String> particularities = new ArrayList<>();
    private String gender;
    private boolean castrated = false;

    public class IncorrectGenderType extends Exception {
        public IncorrectGenderType(String errorMessage) {
            super(errorMessage);
        }
    }

    Sex (String gType) {
        this.gender = gType;
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
