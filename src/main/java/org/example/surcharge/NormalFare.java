package org.example.surcharge;

public class NormalFare implements FareTypeStrategy {
    private static final double SURCHARGE_FEE_NORMAL = 10.0;                // constant value of surcharge fee for normal

    @Override
    public double applySurcharge(double baseFare) {                         // applies surcharge to base fare
        return baseFare + SURCHARGE_FEE_NORMAL;
    }

    @Override
    public String getFareType(){                                            // get fare type
        return "Normal";
    }
}
