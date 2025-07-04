package org.example.surcharge;

public interface FareTypeStrategy {
    double applySurcharge(double baseFare);
    String getFareType();
}


