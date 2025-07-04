package org.example;

public interface FareTypeStrategy {
    double applySurcharge(double baseFare);
    String getFareType();
}

