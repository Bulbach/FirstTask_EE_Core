package by.itAcademy.model;

import java.util.Locale;

import static by.itAcademy.model.Unit.getByUnit;
import static by.itAcademy.model.Unit.valueOf;

public class Speed implements Comparable<Speed> {
    private final double MS_IN_MS;
    private final double MS_IN_KMH;
    private final double MS_IN_MPH;
    private final double MS_IN_KN;

    {
        MS_IN_MS = 1D;
        MS_IN_KMH = 1000D / 3600D;
        MS_IN_MPH = 1609D / 3600D;
        MS_IN_KN = 1852D / 3600D;
    }


    private double value;
    private String unit;

    public Speed(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public double getInMS() {
        switch (getByUnit(unit)) {
            case MS:
                return value;
            case KMH:
                return value * MS_IN_KMH;
            case MPH:
                return value * MS_IN_MPH;
            case KN:
                return value * MS_IN_KN;
        }
        return -1;
    }

    public String inMS() {
        double temp = getInMS();
        return String.format(Locale.ROOT, temp % 1 == 0 ? "%.0f ms" : "%.3f ms", temp);
    }

    @Override
    public String toString() {
        return (int) value + " " + unit;
    }

    @Override
    public int compareTo(Speed o) {
        int result = 0;
        if (this.getInMS() > o.getInMS()) {
            result = 1;
        } else if (this.getInMS() < o.getInMS()) {
            result = -1;
        }
        return result;
    }
}
