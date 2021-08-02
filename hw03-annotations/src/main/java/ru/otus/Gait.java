package ru.otus;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Gait {
    private final Map<String, Double> UNITES_RATIO = new HashMap<String, Double> (Map.of ("m",1.6,"k", 1.0));
    private String gate_name = new String();
    private int middle_speed = 0;
    private boolean natural = true;

    public Gait (String gate_name, int middle_speed) {
        this.gate_name = gate_name.toUpperCase(Locale.ROOT);
        this.middle_speed = middle_speed;
        this.natural = true;
    }

    public Gait (String gate_name, int middle_speed, Boolean natural) {
        this.gate_name = gate_name.toUpperCase(Locale.ROOT);
        this.middle_speed = middle_speed;
        this.natural = natural;
    }

    public String getGait_name() {
        return gate_name;
    }

    @Override
    public String toString() {
        return String.format("Gait name: %s; Gait middle speed: %.3f kph (%.3f mph); The gait is natural %s",
                gate_name, this.getMiddleSpeed("k"),
                this.getMiddleSpeed("m"),
                natural ? "yes" : "no");
    }

    public boolean isNatural() {
        return natural;
    }

    public double getMiddleSpeed(String unit_measure) {
        //k for km m for miles
        double k = middle_speed/UNITES_RATIO.get(unit_measure);
        return k;
    }
}
