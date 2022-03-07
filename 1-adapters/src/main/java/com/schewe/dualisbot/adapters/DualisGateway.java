package com.schewe.dualisbot.adapters;

import com.schewe.dualisbot.adapters.csv.WebscraperInterface;
import com.schewe.dualisbot.application.EntityMatcher;
import com.schewe.dualisbot.domain.dualis.entities.Attempt;
import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.dualis.entities.Module;

import java.util.List;

public class DualisGateway extends WebscraperInterface{

    private final List<Module> oldModules;
    private final List<Exam> oldExams;
    private final List<Module> newModules;
    private final List<Exam> newExams;

    private static final DualisGateway instance = new DualisGateway();

    private DualisGateway(){
        super();

        oldModules = oldModulesCsv.getModules();
        List<Attempt> oldAttempts = oldAttemptsCsv.getAttempts();
        oldExams = oldExamsCsv.getExams();
        EntityMatcher.matchModules(oldModules, oldAttempts, oldExams);

        newModules = newModulesCsv.getModules();
        List<Attempt> newAttempts = newAttemptsCsv.getAttempts();
        newExams = newExamsCsv.getExams();
        EntityMatcher.matchModules(newModules, newAttempts, newExams);

        cleanInterface();
    }

    public static DualisGateway getInstance(){
        return instance;
    }

    public List<Module> getOldModules() {
        return oldModules;
    }

    public List<Exam> getOldExams() {
        return oldExams;
    }

    public List<Module> getNewModules() {
        return newModules;
    }

    public List<Exam> getNewExams() {
        return newExams;
    }
}
