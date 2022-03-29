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

public class ModulesCSV {

    public static String name = "modules.csv";

    private final List<Module> modules = new ArrayList<>();

    public ModulesCSV(CSVReader csvReader) throws Exception {
        for(int i = 0; i < csvReader.getLines().size(); i++) {
            Map<String, String> values = csvReader.getValueMapForLine(i);
            String moduleId = new EmptyConverter(values.get("module_id")).convert();
            String moduleName = new EmptyConverter(values.get("module_name")).convert();
            Semester semester = new SemesterConverter(values.get("semester")).convert();
            Credits credits = new CreditsConverter(values.get("credits")).convert();
            boolean passed = new StatusConverter(values.get("status")).convert();
            Grade grade = new GradeConverter(values.get("final_grade")).convert();

            Module module = new Module(moduleId, moduleName, semester, credits, passed, grade);
            modules.add(module);
        }
    }

    public List<Module> getModules() {
        return modules;
    }
}
