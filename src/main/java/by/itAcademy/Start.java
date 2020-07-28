package by.itAcademy;

import by.itAcademy.comparator.SpeedRangeComparator;
import by.itAcademy.comparator.SpeedUnitComparator;
import by.itAcademy.model.Speed;
import by.itAcademy.model.Unit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Start {

    public static void main(String[] args) {
        List<Speed> coll = readFileInList(getFileName());
        System.out.println();
        printCollectionInMs(coll);
        System.out.println();
       Collections.sort(coll);
       printCollection(coll);
        System.out.println();
        printCollectionSayYes(coll);
        System.out.println();
        Comparator<Speed> scomp = new SpeedRangeComparator()
                .thenComparing(new SpeedUnitComparator());
        coll.sort(scomp);
        printCollection(coll);
    }

    public static void printCollection(List<Speed> coll) {

        for (Speed item : coll) {

            System.out.println(item);
        }
    }

    public static void printCollectionSayYes(List<Speed> coll) {

        String targetUnit = "kmh";
        double targetValue = 2D;
        boolean goal = false;
        for (Speed item : coll) {
            if (item.getValue() == targetValue && item.getUnit().equals(targetUnit)) {
                goal = true;
                break;
            }
        }

        if (goal) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static void printCollectionInMs(List<Speed> coll) {

        for (Speed item : coll) {

            System.out.println(item + " = " + item.inMS());
        }
    }


    public static String getFileName() {

        Scanner fileName = new Scanner(System.in);

        return fileName.nextLine();
    }

    public static List<Speed> readFileInList(String fileName) {

        Path path = Path.of("src\\main\\resources\\file\\" + fileName);

        List<Speed> lines = new ArrayList<>();

        try {
            Files.lines(path)
                    .map(e -> e.split("\\s+", 2))
                    .forEach(x -> lines.add(new Speed(Integer.parseInt(x[0]), x[1])));
        } catch (IOException e) {
            System.out.println(e.getMessage() + "Такого файла не существует");
//            e.printStackTrace();
        }

        return lines;

    }


}
