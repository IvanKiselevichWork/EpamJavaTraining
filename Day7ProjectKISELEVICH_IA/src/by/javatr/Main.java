package by.javatr;

import by.javatr.task1.entity.Array;
import by.javatr.task1.service.ArrayService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array array = new Array(new int[] {6, 2, 13, 7, 4, 3, 1, 9, 5});
        ArrayService arrayService = new ArrayService();
        System.out.println(arrayService.getAllFibonacciNumbers(array));
    }
}
