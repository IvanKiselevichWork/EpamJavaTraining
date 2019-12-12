package by.javatr.task10.unit;

public class Unit {
    private static double funcF(double x) {
        return Math.tan(x);
    }

    //todo
    public static double[][] getValuesTable(double a, double b, double h) {
        double[][] table = null;
        for (double x = a; x <= b; x += h) {
            double f = Unit.funcF(x);
            System.out.printf("%6.3f     %6.3f\n", x, f);
        }
        return table;
    }
}
