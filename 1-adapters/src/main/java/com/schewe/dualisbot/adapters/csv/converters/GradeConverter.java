package com.schewe.dualisbot.adapters.csv.converters;

import com.schewe.dualisbot.abstraction.valueobjects.Grade;

public class GradeConverter extends Converter implements ConverterInterface<Grade> {

    public GradeConverter(String text) {
        super(text);
    }

    @Override
    public Grade convert() throws Exception {
        float floatGrade = Float.parseFloat(text);
        return new Grade(floatGrade);
    }

}
