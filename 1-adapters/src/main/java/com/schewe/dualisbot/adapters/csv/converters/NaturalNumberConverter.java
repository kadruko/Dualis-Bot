package com.schewe.dualisbot.adapters.csv.converters;

import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;

public class NaturalNumberConverter extends Converter implements ConverterInterface<NaturalNumber> {
    public NaturalNumberConverter(String text) {
        super(text);
    }

    @Override
    public NaturalNumber convert() throws Exception {
        int attemptInt = Integer.parseInt(text);
        return new NaturalNumber(attemptInt);
    }
}
