package org.example;

public class normalFare implements FareTypeStrategy {
    private static final double SURCHARGE_FEE_NORMAL = 10.0;

    @Override
    public double applySurcharge(double baseFare) {
        return baseFare + SURCHARGE_FEE_NORMAL;
    }

    @Override
    public String getFareType(){
        return "Normal";
    }
}
