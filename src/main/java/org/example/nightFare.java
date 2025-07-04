package org.example;

public class nightFare implements FareTypeStrategy {
    private static final double SURCHARGE_FEE_NIGHT = 70.0;

    @Override
    public double applySurcharge(double baseFare) {
        return baseFare + SURCHARGE_FEE_NIGHT;

    }

    @Override
    public String getFareType(){
        return "Night";
    }
}
