package by.javatr.task8.unit;

public class Unit {

    public static double funcF(double x) {
        if (x < 3) {
            return (1. / (x * x * x - 6.));
        } else {
            return (9. + 3. * x - x * x);
        }
    }
}
