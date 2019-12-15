package by.javatr.task2.main;

/**
2.  Создать приложение, которое отображает в окне консоли аргументы командной строки метода 
main() в обратном порядке. 
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No args");
            return;
        }

        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }
}