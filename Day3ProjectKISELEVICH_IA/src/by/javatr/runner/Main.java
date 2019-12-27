package by.javatr.runner;

import by.javatr.entity.Ball;
import by.javatr.entity.BallBucket;
import by.javatr.entity.BallColor;
import by.javatr.service.BallBucketService;
import by.javatr.service.exception.CantCountBallsByColorException;
import by.javatr.service.exception.CantCountBucketWeightException;
import by.javatr.service.exception.WrongBallBucketException;
import by.javatr.service.exception.WrongBallColorException;

public class Main {

    public static void main(String[] args) {

        try {
            BallBucket ballBucket = new BallBucket();
            ballBucket.add(new Ball(BallColor.BLUE, 12.5));
            ballBucket.add(new Ball(BallColor.GREEN, 13.5));
            ballBucket.add(new Ball(BallColor.YELLOW, 2.5));
            ballBucket.add(new Ball(BallColor.RED, 16.5));
            ballBucket.add(new Ball(BallColor.RED, 16.5));
            ballBucket.add(new Ball());
            ballBucket.add(new Ball(BallColor.BLUE, 1));
            BallBucketService ballBucketService = new BallBucketService(ballBucket);
            System.out.println("Bucket weight: " + ballBucketService.getWeight());
            System.out.println("Blue balls in bucket count: " + ballBucketService.getBallsCountByColor(BallColor.BLUE));
        } catch (WrongBallBucketException | WrongBallColorException | CantCountBucketWeightException | CantCountBallsByColorException e) {
            System.out.println("Unexpected exception!");
            e.printStackTrace();
        }

    }
}
