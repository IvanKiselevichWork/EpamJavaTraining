package by.javatr.task7.unit;

public class Unit {

    //todo test
    /**
     * @param x1 point1 X-axis
     * @param y1 point1 Y-axis
     * @param x2 point2 X-axis
     * @param y2 point2 Y-axis
     * @return <code>0</code> - equals, <code>1</code> - point1 nearest, <code>2</code> - point2 nearest
     */
    public static int getCenterNearestPoint(double x1, double y1, double x2, double y2) {
        double squareDistance1 = x1 * x1 + y1 * y1;
        double squareDistance2 = x2 * x2 + y2 * y2;
        if (squareDistance1 < squareDistance2) {
            return 1;
        } else if (squareDistance2 < squareDistance1) {
            return 2;
        } else {
            return 0;
        }
    }
}
