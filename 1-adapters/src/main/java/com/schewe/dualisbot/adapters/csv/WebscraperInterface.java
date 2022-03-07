package com.schewe.dualisbot.adapters.csv;

import com.schewe.dualisbot.abstraction.io.CSVReader;
import com.schewe.dualisbot.abstraction.io.FileUtils;

import java.io.File;

public class WebscraperInterface {

    public static String OLD_RESULTS_DIRECTORY = "old-results";
    public static String NEW_RESULTS_DIRECTORY = "new-results";

    protected ModulesCSV oldModulesCsv;
    protected AttemptsCSV oldAttemptsCsv;
    protected ExamsCSV oldExamsCsv;
    protected ModulesCSV newModulesCsv;
    protected AttemptsCSV newAttemptsCsv;
    protected ExamsCSV newExamsCsv;

    public WebscraperInterface() {
        try {
            File oldModulesFile = new File(FileUtils.join(OLD_RESULTS_DIRECTORY, ModulesCSV.name));
            oldModulesCsv = new ModulesCSV(new CSVReader(oldModulesFile));
            File oldAttemptsFile = new File(FileUtils.join(OLD_RESULTS_DIRECTORY, AttemptsCSV.name));
            oldAttemptsCsv = new AttemptsCSV(new CSVReader(oldAttemptsFile));
            File oldExamsFile = new File(FileUtils.join(OLD_RESULTS_DIRECTORY, ExamsCSV.name));
            oldExamsCsv = new ExamsCSV(new CSVReader(oldExamsFile));
            File newModulesFile = new File(FileUtils.join(NEW_RESULTS_DIRECTORY, ModulesCSV.name));
            newModulesCsv = new ModulesCSV(new CSVReader(newModulesFile));
            File newAttemptsFile = new File(FileUtils.join(NEW_RESULTS_DIRECTORY, AttemptsCSV.name));
            newAttemptsCsv = new AttemptsCSV(new CSVReader(newAttemptsFile));
            File newExamsFile = new File(FileUtils.join(NEW_RESULTS_DIRECTORY, ExamsCSV.name));
            newExamsCsv = new ExamsCSV(new CSVReader(newExamsFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void cleanInterface() {
        try {
            FileUtils.copyAllFilesFromDirectory(new File(NEW_RESULTS_DIRECTORY), new File(OLD_RESULTS_DIRECTORY));
            FileUtils.deleteAllFilesFromDirectory(new File(NEW_RESULTS_DIRECTORY));
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }
    }

}
