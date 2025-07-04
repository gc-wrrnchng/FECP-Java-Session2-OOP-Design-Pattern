package org.example;

public class BaseFareStrategyFactory {
    public static BaseFareStrategy getFareStrategy(String rideType) {
        if (rideType == null || rideType.isEmpty()) {
            throw new IllegalArgumentException("Ride type cannot be null or empty");
        }

        switch (rideType.toLowerCase()) {
            case "standard":
                return new StandardStrategy();
            case "premium":
                return new PremiumStrategy();
            default:
                throw new IllegalArgumentException("Unknown ride type: " + rideType);
        }
    }

}
