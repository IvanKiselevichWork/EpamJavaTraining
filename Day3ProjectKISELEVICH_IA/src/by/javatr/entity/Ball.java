package by.javatr.entity;

public class Ball {

    final private static BallColor DEFAULT_BALL_COLOR = BallColor.BLUE;
    final private static double DEFAULT_BALL_WEIGHT = 1;

    private final BallColor ballColor;
    private final double weight;

    // changes:
    //  added default constructor
    //  fixed hashCode
    //  removed equals because of HashSet

    public Ball() {
        this(DEFAULT_BALL_COLOR, DEFAULT_BALL_WEIGHT);
    }

    public Ball(BallColor ballColor, double weight) {
        this.ballColor = ballColor;
        this.weight = weight;
    }

    public BallColor getBallColor() {
        return ballColor;
    }

    public double getWeight() {
        return weight;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                ballColor == ball.ballColor;
    }*/

    @Override
    public int hashCode() {
        return (int) (Double.doubleToLongBits(weight) * 31 + ballColor.ordinal() );
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "ballColor=" + ballColor +
                ", weight=" + weight +
                '}';
    }
}
