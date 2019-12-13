package by.javatr.task9.unit;

import by.javatr.task9.unit.exception.InvalidRadiusException;

public class Unit {

    public static double calculateCircleCircumference(double R) throws InvalidRadiusException {
        if (R < 0) {
            throw new InvalidRadiusException("Invalid radius R, must be R >= 0");
        }
        return Math.PI * 2. * R;
    }
    
    public static double calculateCircleArea(double R) throws InvalidRadiusException  {
        if (R < 0) {
            throw new InvalidRadiusException("Invalid radius R, must be R >= 0");
        }
        return Math.PI * R * R;
    }
}
