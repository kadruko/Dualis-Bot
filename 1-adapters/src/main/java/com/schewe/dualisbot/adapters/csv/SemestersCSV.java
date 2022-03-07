package com.schewe.dualisbot.adapters.csv;

import com.schewe.dualisbot.abstraction.io.CSVReader;
import com.schewe.dualisbot.adapters.csv.converters.SemesterConverter;
import com.schewe.dualisbot.domain.dualis.entities.Semester;

import java.util.ArrayList;
import java.util.List;

public class SemestersCSV {

    public static String name = "semesters.csv";

    private final List<Semester> semesters = new ArrayList<>();

    public SemestersCSV(CSVReader csvReader) throws Exception {
        String[] header = csvReader.getHeader();
        for(String[] line : csvReader.getLines()){
            for(int i = 0; i < line.length; i++){
                String value = line[i].trim();
                if ("semester".equals(header[i])) {
                    Semester semester = new SemesterConverter(value).convert();
                    semesters.add(semester);
                } else {
                    throw new Exception("Unknown header in modules CSV: " + header[i]);
                }
            }
        }
    }

    public List<Semester> getSemesters() {
        return semesters;
    }
}
