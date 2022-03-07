package com.schewe.dualisbot.adapters.csv.converters;

public interface ConverterInterface<Entity> {

    public Entity convert() throws Exception;

}
