package com.schewe.dualisbot.adapters.csv;

import com.schewe.dualisbot.abstraction.io.CSVReader;
import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;
import com.schewe.dualisbot.adapters.csv.converters.EmptyConverter;
import com.schewe.dualisbot.adapters.csv.converters.GradeConverter;
import com.schewe.dualisbot.adapters.csv.converters.NaturalNumberConverter;
import com.schewe.dualisbot.adapters.csv.converters.StatusConverter;
import com.schewe.dualisbot.domain.dualis.entities.Attempt;

import java.util.ArrayList;
import java.util.List;

public class AttemptsCSV {

    public static String name = "attempts.csv";

    private final List<Attempt> attempts = new ArrayList<>();

    public AttemptsCSV(CSVReader csvReader) throws Exception {
        String[] header = csvReader.getHeader();
        for(String[] line : csvReader.getLines()){
            String moduleId = null;
            NaturalNumber attemptNumber = null;
            Grade grade = null;
            boolean passed = false;
            for(int i = 0; i < line.length; i++){
                String value = line[i].trim();
                switch(header[i]){
                    case "module_id":
                        moduleId = new EmptyConverter(value).convert();
                        break;
                    case "attempt":
                        attemptNumber = new NaturalNumberConverter(value).convert();
                        break;
                    case "grade":
                        grade = new GradeConverter(value).convert();
                        break;
                    case "status":
                        passed = new StatusConverter(value).convert();
                        break;
                    default:
                        throw new Exception("Unknown header in attempts CSV: " + header[i]);
                }
            }
            Attempt attempt = new Attempt(moduleId, attemptNumber, grade, passed);
            attempts.add(attempt);
        }
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }
}
