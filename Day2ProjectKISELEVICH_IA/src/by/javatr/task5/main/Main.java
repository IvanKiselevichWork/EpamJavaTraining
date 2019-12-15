package by.javatr.task5.main;

/**
5.  Создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы 
(произведения) и вывода результата на консоль.  
 */
public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No args");
            return;
        }
        int sum = 0;
        int multiplication = 1;
        for (int i = 0; i < args.length; i++) {
            try {
                int number = Integer.parseInt(args[i]);
                sum += number;
                multiplication *= number;
            } catch(NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }
        }

        System.out.println("Sum: " + sum);
        System.out.println("Multiplication: " + multiplication);
    }
}