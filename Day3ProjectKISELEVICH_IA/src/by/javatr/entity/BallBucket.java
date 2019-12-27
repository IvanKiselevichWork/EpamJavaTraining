package by.javatr.entity;

import by.javatr.entity.exception.BucketIsEmptyException;
import by.javatr.entity.exception.RemovingBallFromBucketException;

import java.util.HashSet;
import java.util.Set;

public class BallBucket {
    private final Set<Ball> data;

    // changes:
    //  replaced List with Set
    //  add check for null
    //  add new Exceptions

    public BallBucket() {
        this.data = new HashSet<>();
    }

    public boolean add(Ball ball) {
        if (ball == null) {
            return false;
        }
        return data.add(ball);
    }

    public Ball get() throws BucketIsEmptyException, RemovingBallFromBucketException {
        if(data.isEmpty()) {
            throw new BucketIsEmptyException("Cant get ball from empty bucket");
        }
        Ball ball = data.iterator().next();
        if (!data.remove(ball)) {
            throw new RemovingBallFromBucketException("Error while getting ball from bucket");
        }
        return ball;
    }

    public int getSize() {
        return data.size();
    }


}
