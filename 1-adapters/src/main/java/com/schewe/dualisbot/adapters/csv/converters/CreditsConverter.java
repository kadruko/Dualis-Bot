package com.schewe.dualisbot.adapters.csv.converters;

import com.schewe.dualisbot.domain.dualis.valueobjects.Credits;

public class CreditsConverter extends Converter implements ConverterInterface<Credits> {
    public CreditsConverter(String text) {
        super(text);
    }

    @Override
    public Credits convert() throws Exception {
        int creditsInt = Integer.parseInt(text);
        return new Credits(creditsInt);
    }
}
