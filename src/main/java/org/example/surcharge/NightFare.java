package org.example.surcharge;

public class NightFare implements FareTypeStrategy {
    private static final double SURCHARGE_FEE_NIGHT = 70.0; // constant value of surcharge fee for night

    @Override
    public double applySurcharge(double baseFare) { // applies surcharge to base fare
        return baseFare + SURCHARGE_FEE_NIGHT;
    }

    @Override
    public String getFareType() { // get fare type
        return "Night";
    }
}
