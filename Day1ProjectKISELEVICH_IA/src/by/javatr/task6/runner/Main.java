package by.javatr.task6.runner;

import by.javatr.task6.entity.Timestamp;
import by.javatr.task6.unit.Unit;
import by.javatr.task6.unit.exception.InvalidSecondException;
import by.javatr.view.View;

/**
 * 6.  Идет n-я секунда суток, определить, сколько полных часов, полных минут и секунд прошло к этому
 * моменту.
 */
public class Main {
    public static void main(String[] args) {

        // changes:
        //  removed repetition

        /*
        int second;
        System.out.println("Input second: ");
        try {
            second = CustomScanner.readInteger(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }*/

        int second = View.readInteger("Input second (> 0): ");

        try {
            Timestamp timestamp = Unit.getTimestampFromSecond(second);
            System.out.println("Full hours: " + timestamp.getHours());
            System.out.println("Full minutes: " + timestamp.getMinutes());
            System.out.println("Full seconds: " + timestamp.getSeconds());
        } catch (InvalidSecondException e) {
            System.out.println("Invalid second!");
        }
    }
}
