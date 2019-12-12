package by.javatr.task9.unit;

import by.javatr.task9.unit.exception.InvalidRadiusException;

public class Unit {
    //todo test
    public static double calculateCircleCircumference(double R) throws InvalidRadiusException {
        if (R < 0) {
            throw new InvalidRadiusException();
        }
        return Math.PI * 2. * R;
    }

    //todo test
    public static double calculateCircleArea(double R) throws InvalidRadiusException  {
        if (R < 0) {
            throw new InvalidRadiusException();
        }
        return Math.PI * R * R;
    }
}
