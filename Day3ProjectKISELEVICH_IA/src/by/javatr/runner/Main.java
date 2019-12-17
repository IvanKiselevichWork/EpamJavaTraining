package by.javatr.runner;

import by.javatr.entity.Ball;
import by.javatr.entity.BallBucket;
import by.javatr.entity.BallColor;
import by.javatr.service.BallBucketService;
import by.javatr.service.exception.BallBucketServiceException;

public class Main {

    public static void main(String[] args) {
        BallBucket ballBucket = new BallBucket();
        ballBucket.add(new Ball(BallColor.BLUE, 12.5));
        ballBucket.add(new Ball(BallColor.GREEN, 13.5));
        ballBucket.add(new Ball(BallColor.YELLOW, 2.5));
        ballBucket.add(new Ball(BallColor.RED, 16.5));
        try {
            System.out.println("Bucket weight: " + BallBucketService.getWeight(ballBucket));
            System.out.println("Blue balls in bucket count: " + BallBucketService.getBallsCountByColor(ballBucket, BallColor.BLUE));
        } catch (BallBucketServiceException e) {
            System.out.println("Unexpected error!");
        }

    }
}
