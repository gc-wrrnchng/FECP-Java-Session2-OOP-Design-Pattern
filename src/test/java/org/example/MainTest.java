package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private StandardStrategy standardStrategy;
    private PremiumStrategy premiumStrategy;
    private normalFare normalStrategy;
    private nightFare nightStrategy;

    private double distance;
    private int duration;
    private int standardBaseFare;
    private int premiumBaseFare;


    @BeforeEach
    void setup() {
        standardStrategy = new StandardStrategy();
        premiumStrategy = new PremiumStrategy();
        normalStrategy = new normalFare();
        nightStrategy = new nightFare();
        distance = 10;
        duration = 5;
        standardBaseFare = 15;
        premiumBaseFare = 20;
    }

    @Test
    void testStandardFareNormal() {
        String rideType = "standard";
        String fareType = "normal";
        double baseFare = standardStrategy.calculateFare(distance, duration);
        double surcharge = normalStrategy.applySurcharge(standardBaseFare);
        double actual = baseFare + surcharge;
        assertEquals(165, actual);
    }

    @Test
    void testStandardFareNight() {
        String rideType = "standard";
        String fareType = "night";
        double baseFare = standardStrategy.calculateFare(distance, duration);
        double surcharge = nightStrategy.applySurcharge(standardBaseFare);
        double actual = baseFare + surcharge;
        assertEquals(225, actual);
    }

    @Test
    void testPremiumFareNormal() {
        String rideType = "premium";
        String fareType = "normal";
        double baseFare = premiumStrategy.calculateFare(distance, duration);
        double surcharge = normalStrategy.applySurcharge(premiumBaseFare);
        double actual = baseFare + surcharge;
        assertEquals(250, actual);
    }

    @Test
    void testPremiumFareNight() {
        String rideType = "premium";
        String fareType = "night";
        double baseFare = premiumStrategy.calculateFare(distance, duration);
        double surcharge = nightStrategy.applySurcharge(premiumBaseFare);
        double actual = baseFare + surcharge;
        assertEquals(310, actual);
    }

    @Test
    void testGetFareTypeStrategyReturnsNormal() {
        FareTypeStrategy strategy = FareTypeFactory.getFareTypeStrategy("normal");
        assertInstanceOf(normalFare.class, strategy);
    }

    @Test
    void testGetTypeStrategyReturnsNight() {
        FareTypeStrategy strategy = FareTypeFactory.getFareTypeStrategy("night");
        assertInstanceOf(nightFare.class, strategy);
    }

    @Test
    void testGetFareTypeStrategyCaseSensitivity() {
        FareTypeStrategy strategy = FareTypeFactory.getFareTypeStrategy("NIGHT");
        assertInstanceOf(nightFare.class, strategy);
    }

    @Test
    void testGetFareTypeStrategyUnknownType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FareTypeFactory.getFareTypeStrategy("nigth");
        });
        assertEquals("Unknown fare type: nigth", exception.getMessage());
    }

    @Test
    void testGetFareStrategyReturnsStandard() {
        BaseFareStrategy strategy = BaseFareStrategyFactory.getFareStrategy("standard");
        assertInstanceOf(StandardStrategy.class, strategy);
    }

    @Test
    void testGetFareStrategyReturnsPremium() {
        BaseFareStrategy strategy = BaseFareStrategyFactory.getFareStrategy("premium");
        assertInstanceOf(PremiumStrategy.class, strategy);
    }

    @Test
    void testGetFareStrategyCaseSensitivity() {
        BaseFareStrategy strategy = BaseFareStrategyFactory.getFareStrategy("PREMIUM");
        assertInstanceOf(PremiumStrategy.class, strategy);
    }

    @Test
    void testGetFareStrategyUnknownType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BaseFareStrategyFactory.getFareStrategy("primo");
        });
        assertEquals("Unknown ride type: primo", exception.getMessage());
    }

    @Test
    void testApplySurchargeAddsNightFee() {
        FareTypeStrategy nightFare = new nightFare();

        double baseFare = 150.0;
        double expected = baseFare + 70.0;
        double actual = nightFare.applySurcharge(baseFare);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetFareTypeReturnsNight() {
        FareTypeStrategy nightFare = new nightFare();
        assertEquals("Night", nightFare.getFareType());
    }

    @Test
    void testApplySurchargeAddsNormalFee() {
        FareTypeStrategy normalFare = new normalFare();

        double baseFare = 200.0;
        double expected = baseFare + 10.0;
        double actual = normalFare.applySurcharge(baseFare);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetFareTypeReturnsNormal() {
        FareTypeStrategy normalFare = new normalFare();
        assertEquals("Normal", normalFare.getFareType());
    }

    @Test
    void testCalculateDistanceFareStandard() {
        double distanceCost = standardStrategy.calculateDistanceFare(distance);
        assertEquals(100, distanceCost);
    }

    @Test
    void testCalculateDurationFareStandard() {
        double durationCost = standardStrategy.calculateDurationFare(duration);
        assertEquals(25, durationCost);
    }

    @Test
    void testCalculateDistanceFarePremium() {
        double distanceCost = premiumStrategy.calculateDistanceFare(distance);
        assertEquals(150, distanceCost);
    }

    @Test
    void testCalculateDurationFarePremium() {
        double durationCost = premiumStrategy.calculateDurationFare(duration);
        assertEquals(50, durationCost);
    }

}

