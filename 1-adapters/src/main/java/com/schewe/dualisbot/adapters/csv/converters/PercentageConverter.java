package com.schewe.dualisbot.adapters.csv.converters;

import com.schewe.dualisbot.abstraction.valueobjects.Percentage;

public class PercentageConverter extends Converter implements ConverterInterface<Percentage> {
    public PercentageConverter(String text) {
        super(text);
    }

    @Override
    public Percentage convert() throws Exception {
        String preprocessedWeighting = text.replace("%", "");
        float floatWeighting = Float.parseFloat(preprocessedWeighting) / 100;
        return new Percentage(floatWeighting);
    }
}
