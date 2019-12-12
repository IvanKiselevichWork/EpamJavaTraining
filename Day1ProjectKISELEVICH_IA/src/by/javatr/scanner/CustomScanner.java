package by.javatr.scanner;

import by.javatr.scanner.exception.CustomScannerException;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomScanner {
    @SuppressWarnings("resource")
    public static int readInteger(InputStream in) throws CustomScannerException {
        try {
            Scanner scanner = new Scanner(in);
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
            }
            return scanner.nextInt();
        } catch (IllegalStateException | NoSuchElementException e) {
            throw new CustomScannerException(e);
        }
    }

    @SuppressWarnings("resource")
    public static double readDouble(InputStream in) throws CustomScannerException {
        try {
            Scanner scanner = new Scanner(in);
            while (!scanner.hasNextDouble()) {
                scanner.nextLine();
            }
            return scanner.nextDouble();
        } catch (IllegalStateException | NoSuchElementException e) {
            throw new CustomScannerException(e);
        }
    }
}
