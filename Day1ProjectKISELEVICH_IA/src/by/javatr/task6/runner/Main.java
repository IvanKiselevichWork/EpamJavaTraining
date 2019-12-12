package by.javatr.task6.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.CustomScannerException;
import by.javatr.task6.entity.Timestamp;
import by.javatr.task6.unit.Unit;
import by.javatr.task6.unit.exception.InvalidSecondException;

public class Main {
    public static void main(String[] args) {

        int second;
        System.out.println("Input second: ");
        try {
            second = CustomScanner.readInteger(System.in);
        } catch (CustomScannerException e) {
            System.out.println("Input error!");
            return;
        }

        try {
            Timestamp timestamp = Unit.getTimestampFromSecond(second);
            System.out.println("Full hours: " + timestamp.getHours());
            System.out.println("Full minutes: " + timestamp.getMinutes());
            System.out.println("Full seconds: " + timestamp.getSeconds());
        } catch (InvalidSecondException e) {
            System.out.println("Invalid second!");
        }
    }
}
