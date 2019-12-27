package by.javatr.service;

import by.javatr.entity.Ball;
import by.javatr.entity.BallBucket;
import by.javatr.entity.BallColor;
import by.javatr.entity.exception.BucketIsEmptyException;
import by.javatr.entity.exception.RemovingBallFromBucketException;
import by.javatr.service.exception.CantCountBallsByColorException;
import by.javatr.service.exception.WrongBallBucketException;
import by.javatr.service.exception.CantCountBucketWeightException;
import by.javatr.service.exception.WrongBallColorException;

public class BallBucketService {

    // changes:
    //  class non-static now
    //  class check nulls and throws more clear exceptions

    private BallBucket ballBucket;

    public BallBucketService(BallBucket ballBucket) throws WrongBallBucketException {
        if (ballBucket == null) {
            throw new WrongBallBucketException("ballBucket argument is null!");
        }
        this.ballBucket = ballBucket;
    }

    public double getWeight() throws CantCountBucketWeightException {
        try {
            double weight = 0;
            BallBucket tempBucket = new BallBucket();
            int size = ballBucket.getSize();
            for (int i = 0; i < size; i++) {

                Ball ball = ballBucket.get();
                weight += ball.getWeight();

                if(!tempBucket.add(ball)) {
                    throw new CantCountBucketWeightException("Cant add ball to temp bucket while counting weight");
                }
            }
            ballBucket = tempBucket;
            return weight;
        } catch (BucketIsEmptyException | RemovingBallFromBucketException e) {
            throw new CantCountBucketWeightException(e);
        }
    }

    public int getBallsCountByColor(BallColor ballColor) throws WrongBallColorException, CantCountBallsByColorException {
        if (ballColor == null) {
            throw new WrongBallColorException("ballColor argument is null");
        }

        try {
            int count = 0;
            BallBucket tempBucket = new BallBucket();
            int size = ballBucket.getSize();
            for (int i = 0; i < size; i++) {

                Ball ball = ballBucket.get();
                if (ball.getBallColor() == ballColor) {
                    count++;
                }

                if(!tempBucket.add(ball)) {
                    throw new CantCountBallsByColorException("Cant add ball to temp bucket while counting ball by color");
                }
            }
            ballBucket = tempBucket;
            return count;
        } catch (BucketIsEmptyException | RemovingBallFromBucketException e) {
            throw new CantCountBallsByColorException(e);
        }
    }
}
