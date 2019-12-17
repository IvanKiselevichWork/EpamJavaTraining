package by.javatr.entity;

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


}
