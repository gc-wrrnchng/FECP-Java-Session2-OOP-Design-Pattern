package org.example;

public class PremiumStrategy implements BaseFareStrategy {
    private static final double BASE_FARE = 20.0;
    private static final double PER_KM_RATE = 15.0;
    private static final double PER_MINUTE_RATE = 10.0;

    @Override
    public double calculateFare(double distance, int durationMinutes) {
        double distanceFare = distance * PER_KM_RATE;
        double durationFare = durationMinutes * PER_MINUTE_RATE;
        return BASE_FARE + distanceFare + durationFare;
    }
}
