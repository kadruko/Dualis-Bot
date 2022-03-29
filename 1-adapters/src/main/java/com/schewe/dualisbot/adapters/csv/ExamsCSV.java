package com.schewe.dualisbot.adapters.csv;

import com.schewe.dualisbot.abstraction.io.CSVReader;
import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;
import com.schewe.dualisbot.abstraction.valueobjects.Percentage;
import com.schewe.dualisbot.adapters.csv.converters.*;
import com.schewe.dualisbot.domain.dualis.entities.Attempt;
import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.dualis.valueobjects.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExamsCSV {

    public static String name = "exams.csv";

    private final List<Exam> exams = new ArrayList<>();

    public ExamsCSV(CSVReader csvReader) throws Exception {
        for(int i = 0; i < csvReader.getLines().size(); i++){
            Map<String, String> values = csvReader.getValueMapForLine(i);
            String name = new EmptyConverter(values.get("exam_name")).convert();
            Percentage weighting = new PercentageConverter(values.get("weighting")).convert();
            Rating rating = new RatingConverter(values.get("rating")).convert();
            NaturalNumber attemptNumber = new NaturalNumberConverter(values.get("attempt")).convert();
            String moduleId = new EmptyConverter(values.get("module_id")).convert();

            Exam exam = new Exam(name, weighting, rating, attemptNumber, moduleId);
            exams.add(exam);
        }
    }

    public List<Exam> getExams(){
        return exams;
    }

}
