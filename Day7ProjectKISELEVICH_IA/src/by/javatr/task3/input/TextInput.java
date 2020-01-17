package by.javatr.task3.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TextInput {

    /**
     *
     * @return String from console
     */
    public String inputTextFromConsole() {
        System.out.println("Input line:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     *
     * @param path to file
     * @return String from file
     * @throws IOException if path is null or incorrect
     */
    public String inputTextFromFile(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
