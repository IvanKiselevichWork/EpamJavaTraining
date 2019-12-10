package by.javatr.task1.runner;

import by.javatr.scanner.CustomScanner;
import by.javatr.task1.unit.Unit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input integer");
        int number = CustomScanner.readInteger(System.in);
        System.out.println("Number = " + number);
        int lastDigit = Unit.getLastDigit(number);
        //System.out.println("Last digit = " + lastDigit);
        int lastDigitOfSqr = Unit.getLastDigitOfSqr(lastDigit);
        System.out.println("Last digit of sqr = " + lastDigitOfSqr);
    }
}
