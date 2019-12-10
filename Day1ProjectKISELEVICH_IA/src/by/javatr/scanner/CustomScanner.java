package by.javatr.scanner;

import java.io.InputStream;
import java.util.Scanner;

public class CustomScanner {
    @SuppressWarnings("resource")
    public static int readInteger(InputStream in) {
        Scanner scanner = new Scanner(in);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        return  scanner.nextInt();
    }
}
