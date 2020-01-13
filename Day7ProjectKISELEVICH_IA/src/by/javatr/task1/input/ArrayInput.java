package by.javatr.task1.input;

import by.javatr.task1.entity.Array;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayInput {

    /**
     *
     * @return Array created with console input
     */
    public Array inputArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        int count;
        while(true) {
            System.out.println("Input numbers count:");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
                System.out.println("Invalid input!");
            }
        }
        if (count > 0) {
            System.out.println("Input " + count + " number(s):");
        }
        int[] nums = new int[count];
        while (count > 0) {
            int num;
            while(true) {
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    break;
                } else {
                    scanner.nextLine();
                    System.out.println("Invalid input!");
                }
            }
            nums[nums.length - count--] = num;
        }
        return new Array(nums);
    }

    /**
     *
     * @param path to file
     * @return Array created with values from file, delimiter - space, new line
     * @throws IOException if path is incorrect
     */
    public Array inputArrayFromFile(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        List<Integer> nums = new ArrayList<>();
        for (String line : lines) {
            Scanner scanner = new Scanner(line);
            while (scanner.hasNextInt()) {
                nums.add(scanner.nextInt());
            }
        }
        Array array = new Array(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            array.set(i, nums.get(i));
        }
        return array;
    }
}
