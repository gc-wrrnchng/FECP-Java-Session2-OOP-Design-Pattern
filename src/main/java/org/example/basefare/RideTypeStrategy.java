package org.example.basefare;

public interface RideTypeStrategy {
    double calculateFare(double distance, int durationMinutes);

    double calculateDistanceFare(double distance);

    double calculateDurationFare(int durationMinutes);
}
