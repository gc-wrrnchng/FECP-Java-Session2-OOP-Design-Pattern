package org.example.basefare;

public class RideTypeFactory {
    public static RideTypeStrategy getFareStrategy(String rideType) {
        if (rideType == null || rideType.isEmpty()) {
            throw new IllegalArgumentException("Ride type cannot be null or empty");
        }

        switch (rideType.toLowerCase()) {
            case "standard":
                return new StandardRide();
            case "premium":
                return new PremiumRide();
            default:
                throw new IllegalArgumentException("Unknown ride type: " + rideType);
        }
    }

}
