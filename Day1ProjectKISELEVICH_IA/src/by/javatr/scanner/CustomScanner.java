package by.javatr.scanner;

import by.javatr.scanner.exception.DataNotFoundException;
import by.javatr.scanner.exception.DataSourceException;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomScanner {
    /*
        changes:
            removed unclear exception CustomScannerException
            created 2 clear exceptions DataSourceException, DataNotFoundException
            add check for null
     */
    @SuppressWarnings("resource")
    public static int readInteger(InputStream in) throws DataSourceException, DataNotFoundException {
        if (in == null) {
            throw new DataSourceException("InputStream is null");
        }
        try {
            Scanner scanner = new Scanner(in);
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
            }
            return scanner.nextInt();
        } catch (IllegalStateException e) {
            throw new DataSourceException(e);
        } catch (NoSuchElementException e) {
            throw new DataNotFoundException(e);
        }
    }

    @SuppressWarnings("resource")
    public static double readDouble(InputStream in) throws DataSourceException, DataNotFoundException  {
        if (in == null) {
            throw new DataSourceException("InputStream is null");
        }
        try {
            Scanner scanner = new Scanner(in);
            while (!scanner.hasNextDouble()) {
                scanner.nextLine();
            }
            return scanner.nextDouble();
        } catch (IllegalStateException e) {
            throw new DataSourceException(e);
        } catch (NoSuchElementException e) {
            throw new DataNotFoundException(e);
        }
    }
}
