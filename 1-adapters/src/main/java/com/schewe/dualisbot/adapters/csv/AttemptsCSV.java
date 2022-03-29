package com.schewe.dualisbot.adapters.csv;

import com.schewe.dualisbot.abstraction.io.CSVReader;
import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;
import com.schewe.dualisbot.adapters.csv.converters.*;
import com.schewe.dualisbot.application.ExamsComparator;
import com.schewe.dualisbot.domain.dualis.entities.Attempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttemptsCSV {

    public static String name = "attempts.csv";

    private final List<Attempt> attempts = new ArrayList<>();

    public AttemptsCSV(CSVReader csvReader) throws Exception {
        for(int i = 0; i < csvReader.getLines().size(); i++){
            Map<String, String> values = csvReader.getValueMapForLine(i);
            String moduleId = new EmptyConverter(values.get("module_id")).convert();
            NaturalNumber attemptNumber = new NaturalNumberConverter(values.get("attempt")).convert();
            Grade grade = new GradeConverter(values.get("grade")).convert();
            boolean passed = new StatusConverter(values.get("status")).convert();

            Attempt attempt = new Attempt(moduleId, attemptNumber, grade, passed);
            attempts.add(attempt);
        }
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }
}
