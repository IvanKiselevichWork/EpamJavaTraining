package by.javatr.task4.unit;

public class Unit {
    public static boolean isArrayHasTwoEvenNumbers(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            if((number % 2 == 0)) {
                result++;
                if (result >= 2) {
                    break;
                }
            }
        }
        if (result >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
