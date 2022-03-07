package com.schewe.dualisbot.adapters.csv;

import com.schewe.dualisbot.abstraction.io.CSVReader;
import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;
import com.schewe.dualisbot.abstraction.valueobjects.Percentage;
import com.schewe.dualisbot.adapters.csv.converters.EmptyConverter;
import com.schewe.dualisbot.adapters.csv.converters.NaturalNumberConverter;
import com.schewe.dualisbot.adapters.csv.converters.PercentageConverter;
import com.schewe.dualisbot.adapters.csv.converters.RatingConverter;
import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.dualis.valueobjects.Rating;

import java.util.ArrayList;
import java.util.List;

public class ExamsCSV {

    public static String name = "exams.csv";

    private final List<Exam> exams = new ArrayList<>();

    public ExamsCSV(CSVReader csvReader) throws Exception {
        String[] header = csvReader.getHeader();
        for(String[] line : csvReader.getLines()){
            String name = null;
            Percentage weighting = null;
            Rating rating = null;
            NaturalNumber attemptNumber = null;
            String moduleId = null;
            for(int i = 0; i < line.length; i++){
                String value = line[i].trim();
                switch(header[i]){
                    case "exam_name":
                        name = new EmptyConverter(value).convert();
                        break;
                    case "weighting":
                        weighting = new PercentageConverter(value).convert();
                        break;
                    case "rating":
                        rating = new RatingConverter(value).convert();
                        break;
                    case "attempt":
                        attemptNumber = new NaturalNumberConverter(value).convert();
                        break;
                    case "module_id":
                        moduleId = new EmptyConverter(value).convert();
                        break;
                    default:
                        throw new Exception("Unknown header in exams CSV: " + header[i]);
                }
            }
            Exam exam = new Exam(name, weighting, rating, attemptNumber, moduleId);
            exams.add(exam);
        }
    }

    public List<Exam> getExams(){
        return exams;
    }

}
