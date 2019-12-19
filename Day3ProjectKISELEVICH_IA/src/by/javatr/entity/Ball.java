package by.javatr.entity;

import java.util.Objects;

public class Ball {
    private BallColor ballColor;
    private double weight;

    public Ball(BallColor ballColor, double weight) {
        this.ballColor = ballColor;
        this.weight = weight;
    }

    public BallColor getBallColor() {
        return ballColor;
    }

    public void setBallColor(BallColor ballColor) {
        this.ballColor = ballColor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                ballColor == ball.ballColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballColor, weight);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "ballColor=" + ballColor +
                ", weight=" + weight +
                '}';
    }
}
