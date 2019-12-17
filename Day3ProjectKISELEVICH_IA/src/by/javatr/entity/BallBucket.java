package by.javatr.entity;

import java.util.ArrayList;
import java.util.List;

public class BallBucket {
    private List<Ball> data;

    public BallBucket() {
        this.data = new ArrayList<>();
    }

    public boolean add(Ball ball) {
        return data.add(ball);
    }

    public Ball get(int index) {
        return data.get(index);
    }

    public int size() {
        return data.size();
    }
}
