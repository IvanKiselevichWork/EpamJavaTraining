package by.javatr.task5.runner;

import by.javatr.task5.unit.Unit;
import by.javatr.view.View;

/**
 * 5.  Составить программу, печатающую значение true, если указанное высказывание является истинным, и
 * false  —  в противном  случае:  является  ли  целое  число  совершенным  (сумма  делителей  равна  самому
 * числу).
 */
public class Main {
    public static void main(String[] args) {
        // changes:
        //  removed repetition

        /*
        System.out.println("Input integer: ");
        int number;
        try {
            number = CustomScanner.readInteger(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }*/

        int number = View.readInteger("Input integer: ");

        System.out.println(Unit.isNumberPerfect(number));
    }
}
