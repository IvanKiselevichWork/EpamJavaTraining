package by.javatr.view;

import by.javatr.scanner.CustomScanner;
import by.javatr.scanner.exception.DataNotFoundException;
import by.javatr.scanner.exception.DataSourceException;

public class View {
    public static int readInteger(String message) {
        System.out.println(message);
        int x;
        try {
            x = CustomScanner.readInteger(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            throw new RuntimeException(e);
        }
        return x;
    }

    public static double readDouble(String message) {
        System.out.println(message);
        double x;
        try {
            x = CustomScanner.readInteger(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            throw new RuntimeException(e);
        }
        return x;
    }
}
