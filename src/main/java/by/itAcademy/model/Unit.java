package by.itAcademy.model;

import java.util.Arrays;

import static java.util.Arrays.stream;

public enum Unit {

    MS("ms",4),
    KMH("kmh",1),
    MPH("mph",2),
    KN("kn",3);

    private final String VALUE;
    private final int RANGE;

    Unit(String unit,int RANGE) {
        VALUE = unit;
        this.RANGE=RANGE;
    }

    public String getVALUE() {
        return VALUE;
    }

    public int getRANGE() {
        return RANGE;
    }

    public static Unit getByUnit(String unit){
        return Arrays.stream(values()).filter(i -> i.getVALUE().equals(unit)).findFirst().get();
    }
}
