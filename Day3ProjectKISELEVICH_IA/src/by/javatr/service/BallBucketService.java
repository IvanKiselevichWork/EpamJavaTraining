package by.javatr.service;

import by.javatr.entity.BallBucket;
import by.javatr.entity.BallColor;
import by.javatr.entity.exception.BallIndexOutOfBounds;
import by.javatr.service.exception.BallBucketServiceException;

public class BallBucketService {
    //добавить роле BallBucket
    //сделать нестатическим
    public static double getWeight(BallBucket ballBucket) throws BallBucketServiceException {
        if (ballBucket == null) {
            throw new BallBucketServiceException("ballBucket argument is null");
        }

        double weight = 0;
        for(int i = 0; i < ballBucket.size(); i++) {
            // я думаю, что тут try-catch для BallIndexOutOfBounds при ballBucket.get(i) не нужен,
            // т.к. i < ballBucket.size()
            weight += ballBucket.get(i).getWeight();
        }
        return weight;
    }

    public static int getBallsCountByColor(BallBucket ballBucket, BallColor ballColor) throws BallBucketServiceException {
        if (ballBucket == null) {
            throw new BallBucketServiceException("ballBucket argument is null");
        }
        if (ballColor == null) {
            throw new BallBucketServiceException("ballColor argument is null");
        }

        int count = 0;
        for(int i = 0; i < ballBucket.size(); i++) {
            // я думаю, что тут try-catch для BallIndexOutOfBounds при ballBucket.get(i) не нужен,
            // т.к. i < ballBucket.size()
            if (ballBucket.get(i).getBallColor() == ballColor) {
                count++;
            }
        }
        return count;
    }
}
