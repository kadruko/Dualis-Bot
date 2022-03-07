package com.schewe.dualisbot.adapters.csv.converters;

import com.schewe.dualisbot.domain.dualis.entities.Semester;
import com.schewe.dualisbot.domain.dualis.enumerations.SemesterType;

import java.time.Year;

public class SemesterConverter extends Converter implements ConverterInterface<Semester>{
    public SemesterConverter(String text) {
        super(text);
    }

    @Override
    public Semester convert() throws Exception {
        String typeString = text.split(" ")[0];
        String yearString = text.split(" ")[1].split("/")[0];
        SemesterType semesterType = typeString.equals("SoSe") ? SemesterType.Summer : SemesterType.Winter;
        Year year = Year.of(Integer.parseInt(yearString));
        return new Semester(year, semesterType);
    }
}
