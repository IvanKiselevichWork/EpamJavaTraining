package by.javatr.task1.input;

import by.javatr.task1.entity.Array;

import java.util.Scanner;

public class ArrayInput {
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
}
