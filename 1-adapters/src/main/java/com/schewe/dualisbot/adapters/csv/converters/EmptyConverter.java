package com.schewe.dualisbot.adapters.csv.converters;

public class EmptyConverter extends Converter implements ConverterInterface<String>{

    public EmptyConverter(String text) {
        super(text);
    }

    @Override
    public String convert() throws Exception {
        return text;
    }
}
