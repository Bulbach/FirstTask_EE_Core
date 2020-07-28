package by.itAcademy.comparator;

import by.itAcademy.model.Speed;
import by.itAcademy.model.Unit;

import java.util.Comparator;


public class SpeedRangeComparator implements Comparator<Speed> {

    @Override
    public int compare(Speed o1, Speed o2) {
       int a = Unit.getByUnit(o1.getUnit()).getRANGE();
       int b = Unit.getByUnit(o2.getUnit()).getRANGE();

        return a<b ? -1:a == b? 0: 1;
    }
}
