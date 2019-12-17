package by.javatr.service;

import by.javatr.entity.BallBucket;
import by.javatr.entity.BallColor;
import by.javatr.service.exception.BallBucketServiceException;

public class BallBucketService {
    public static double getWeight(BallBucket ballBucket) throws BallBucketServiceException {
        if (ballBucket == null) {
            throw new BallBucketServiceException("ballBucket argument is null");
        }

        double weight = 0;
        for(int i = 0; i < ballBucket.size(); i++) {
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
            if (ballBucket.get(i).getBallColor() == ballColor) {
                count++;
            }
        }
        return count;
    }
}
