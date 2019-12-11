package by.javatr.task6.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task6.entity.Timestamp;
import by.javatr.task6.unit.Unit;

public class Main {
    public static void main(String[] args) {

        int second = -1;
        do {
            System.out.println("Input second: ");
            second = CustomScanner.readInteger(System.in);
        }
        while(second < 0);

        Timestamp timestamp = Unit.getTimestampFromSecond(second);
        System.out.println("Full hours: " + timestamp.getHours());
        System.out.println("Full minutes: " + timestamp.getMinutes());
        System.out.println("Full seconds: " + timestamp.getSeconds());
    }
}
