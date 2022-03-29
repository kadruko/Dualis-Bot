package com.schewe.dualisbot.adapters.csv;

import com.schewe.dualisbot.abstraction.io.CSVReader;
import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.adapters.csv.converters.*;
import com.schewe.dualisbot.domain.dualis.entities.Module;
import com.schewe.dualisbot.domain.dualis.entities.Semester;
import com.schewe.dualisbot.domain.dualis.valueobjects.Credits;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SemestersCSV {

    public static String name = "semesters.csv";

    private final List<Semester> semesters = new ArrayList<>();

    public SemestersCSV(CSVReader csvReader) throws Exception {
        for(int i = 0; i < csvReader.getLines().size(); i++) {
            Map<String, String> values = csvReader.getValueMapForLine(i);
            Semester semester = new SemesterConverter(values.get("semester")).convert();
            semesters.add(semester);
        }
    }

    public List<Semester> getSemesters() {
        return semesters;
    }
}
