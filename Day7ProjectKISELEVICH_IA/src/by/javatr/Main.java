package by.javatr;

import by.javatr.task1.entity.Array;
import by.javatr.task1.service.ArrayService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array array = new Array(new int[] {6, 25, 104, 7, 475, 333, 2541, 9999, 5});
        ArrayService arrayService = new ArrayService();
        System.out.println(arrayService.getAllThreeSignNumbersWithNoEqualsSign(array));
    }
}
