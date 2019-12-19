package by.javatr.entity;

import by.javatr.entity.exception.BallIndexOutOfBounds;

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
        rangeCheck(index);
        return data.get(index);
    }

    public int size() {
        return data.size();
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= data.size()) {
            throw new BallIndexOutOfBounds();
        }
    }
}
