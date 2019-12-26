package by.javatr.task9.runner;

import by.javatr.task9.unit.Unit;
import by.javatr.task9.unit.exception.InvalidRadiusException;
import by.javatr.view.View;

/**
 * 9.  Вычислить длину окружности и площадь круга одного и того же заданного радиуса R.
 */
public class Main {
    public static void main(String[] args) {

        // changes:
        //  removed repetition

        /*
        System.out.println("Input R: ");
        double R;
        try {
            R = CustomScanner.readDouble(System.in);
        } catch (DataNotFoundException | DataSourceException e) {
            System.out.println("Input error!");
            return;
        }*/

        double R = View.readDouble("Input R: ");

        try {
            double circumference = Unit.calculateCircleCircumference(R);
            double area = Unit.calculateCircleArea(R);
            System.out.println("Circle circumference = " + circumference);
            System.out.println("Circle area = " + area);
        } catch (InvalidRadiusException e) {
            System.out.println("Invalid radius");
        }

    }
}
