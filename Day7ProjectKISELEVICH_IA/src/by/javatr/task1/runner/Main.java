package by.javatr.task1.runner;

import by.javatr.task1.entity.Array;
import by.javatr.task1.input.ArrayInput;
import by.javatr.task1.service.ArrayService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Array array = new Array(new int[] {6, 25, 104, 7, 475, 333, 2541, 9999, 5, 13});
        ArrayService arrayService = new ArrayService();
        //System.out.println(arrayService.getAllThreeSignNumbersWithNoEqualsSign(array));
        //System.out.println(new ArrayInput().inputArrayWithRandom(10));

        System.out.println(arrayService.getAllFibonacciNumbers(array));
    }
}
