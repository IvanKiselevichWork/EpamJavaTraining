package by.javatr;

import by.javatr.task1.entity.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array array = new Array(new int[] {6, 2, 7, 4, 3, 1, 9, 5});
        System.out.println(array);
        int index = array.sortAndFindElement(97);
        System.out.println(array);
        int value = index > 0? array.get(index) : -1;
        System.out.println(index + ", " + value);
    }
}
