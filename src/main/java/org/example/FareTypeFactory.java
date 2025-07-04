package org.example;

public class FareTypeFactory {
    public static FareTypeStrategy getFareTypeStrategy(String fareType){
        if(fareType == null){                                       // returns null if fareType entered is null
            return null;
        }
        switch(fareType.toLowerCase()){                             // converts input to lowercase
            case "night":
                return new nightFare();                             // returns computed night fare

            case "normal":
                return new normalFare();                            // returns computed normal fare

            default:
                throw new IllegalArgumentException("Unknown fare type: " + fareType);
        }
    }
}
