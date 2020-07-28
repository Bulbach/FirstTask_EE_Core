package by.itAcademy.comparator;

import by.itAcademy.model.Speed;

import java.util.Comparator;

public class SpeedUnitComparator implements Comparator<Speed> {
    @Override
    public int compare(Speed o1, Speed o2) {
        double a = o2.getValue();
        double b = o1.getValue();

        return a < b ? -1 : a > b ? 1 : 0;
    }
}
