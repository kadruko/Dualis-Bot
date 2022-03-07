package com.schewe.dualisbot.adapters.csv.converters;

public class StatusConverter extends Converter implements ConverterInterface<Boolean>{
    public StatusConverter(String text) {
        super(text);
    }

    @Override
    public Boolean convert() throws Exception {
        return text.equals("bestanden");
    }
}
