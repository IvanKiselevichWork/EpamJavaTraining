package by.javatr.task3.main;

import java.util.Random;
import java.util.Scanner;

/**
3.  Создать  приложение,  выводящее  заданное  количество  случайных  чисел  с  переходом  и  без 
перехода на новую строку. 
 */
public class Main {
    public static void main(String[] args) {

        //todo number count from args or System.in?
        System.out.println("Input numbers count with newline");
        int countWithNewLine;
        try {
            countWithNewLine = new Scanner(System.in).nextInt();
        } catch(Exception e) {
            System.out.println("Invalid input");
            return;
        }

        System.out.println("Input numbers count without newline");
        int countWithoutNewLine;
        try {
            countWithoutNewLine = new Scanner(System.in).nextInt();
        } catch(Exception e) {
            System.out.println("Invalid input");
            return;
        }

        System.out.println("Random integers with newline");
        for (int i = 0; i < countWithNewLine; i++) {
            System.out.println(new Random().nextInt(9));
        }

        System.out.println("Random integers without newline");
        for (int i = 0; i < countWithoutNewLine; i++) {
            System.out.print(new Random().nextInt(9) + " ");
        }
    }
}