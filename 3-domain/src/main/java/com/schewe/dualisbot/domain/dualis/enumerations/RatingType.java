package com.schewe.dualisbot.domain.dualis.enumerations;

public enum RatingType {

    PERCENTAGE("%"),
    GRADE("");

    private final String symbol;

    RatingType(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
