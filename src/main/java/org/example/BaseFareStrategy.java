package org.example;

public interface BaseFareStrategy {
    double calculateFare(double distance, int durationMinutes);

    double calculateDistanceFare(double distance);

    double calculateDurationFare(int durationMinutes);
}
