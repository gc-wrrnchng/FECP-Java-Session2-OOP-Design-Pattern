package org.example.surcharge;

public class FareTypeFactory {
    public static FareTypeStrategy getFareTypeStrategy(String fareType){
        if(fareType == null){                                       // returns null if fareType entered is null
            return null;
        }
        switch(fareType.toLowerCase()){                             // converts input to lowercase
            case "night":
                return new NightFare();                             // returns computed night fare

            case "normal":
                return new NormalFare();                            // returns computed normal fare

            default:
                return null;
        }
    }
}
