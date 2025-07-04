package org.example;

public class FareTypeFactory {
    public static FareTypeStrategy getFareTypeStrategy(String fareType){
        if(fareType == null){
            return null;
        }
        switch(fareType.toLowerCase()){
            case "night":
                return new nightFare();

            case "normal":
                return new normalFare();

            default:
                return null;
        }
    }
}
