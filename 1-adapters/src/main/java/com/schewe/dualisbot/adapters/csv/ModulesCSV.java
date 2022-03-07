package com.schewe.dualisbot.adapters.csv;

import com.schewe.dualisbot.abstraction.io.CSVReader;
import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.adapters.csv.converters.*;
import com.schewe.dualisbot.domain.dualis.entities.Module;
import com.schewe.dualisbot.domain.dualis.entities.Semester;
import com.schewe.dualisbot.domain.dualis.valueobjects.Credits;

import java.util.ArrayList;
import java.util.List;

public class ModulesCSV {

    public static String name = "modules.csv";

    private final List<Module> modules = new ArrayList<>();

    public ModulesCSV(CSVReader csvReader) throws Exception {
        String[] header = csvReader.getHeader();
        for(String[] line : csvReader.getLines()){
            String moduleId = null;
            String moduleName = null;
            Semester semester = null;
            Credits credits = null;
            boolean passed = false;
            Grade grade = null;
            for(int i = 0; i < line.length; i++){
                String value = line[i].trim();
                switch(header[i]){
                    case "module_id":
                        moduleId = new EmptyConverter(value).convert();
                        break;
                    case "module_name":
                        moduleName = new EmptyConverter(value).convert();
                        break;
                    case "semester":
                        semester = new SemesterConverter(value).convert();
                        break;
                    case "credits":
                        credits = new CreditsConverter(value).convert();
                        break;
                    case "status":
                        passed = new StatusConverter(value).convert();
                        break;
                    case "final_grade":
                        grade = new GradeConverter(value).convert();
                        break;
                    default:
                        throw new Exception("Unknown header in modules CSV: " + header[i]);
                }
            }
            Module module = new Module(moduleId, moduleName, semester, credits, passed, grade);
            modules.add(module);
        }
    }

    public List<Module> getModules() {
        return modules;
    }
}
