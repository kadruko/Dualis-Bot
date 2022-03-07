package com.schewe.dualisbot.adapters.csv.converters;

import com.schewe.dualisbot.domain.dualis.valueobjects.Rating;

public class RatingConverter extends Converter implements ConverterInterface<Rating> {
    public RatingConverter(String text) {
        super(text);
    }

    @Override
    public Rating convert() throws Exception {
        boolean isPercentage = text.contains("%");
        if(isPercentage){
            return new Rating(new PercentageConverter(text).convert());
        }else{
            return new Rating(new GradeConverter(text).convert());
        }
    }
}
