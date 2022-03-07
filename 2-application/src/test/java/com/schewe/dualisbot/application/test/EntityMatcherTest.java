package com.schewe.dualisbot.application.test;

import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;
import com.schewe.dualisbot.abstraction.valueobjects.Percentage;
import com.schewe.dualisbot.application.EntityMatcher;
import com.schewe.dualisbot.domain.dualis.entities.Attempt;
import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.dualis.entities.Module;
import com.schewe.dualisbot.domain.dualis.entities.Semester;
import com.schewe.dualisbot.domain.dualis.enumerations.SemesterType;
import com.schewe.dualisbot.domain.dualis.valueobjects.Credits;
import com.schewe.dualisbot.domain.dualis.valueobjects.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class EntityMatcherTest {

    List<Module> modules;
    List<Attempt> attempts;
    List<Exam> exams;

    @BeforeEach
    public void beforeEach() throws Exception {
        modules = new ArrayList<>();
        attempts = new ArrayList<>();
        exams = new ArrayList<>();
        Module module = new Module("T3INF2005", "Technische Informatik II", new Semester(Year.of(2021), SemesterType.Summer), new Credits(5), true, new Grade(1.7f));
        modules.add(module);
    }

    @Test
    public void matchModulesAttemptIncluded() throws Exception {
        Attempt attemptIncluded = new Attempt("T3INF2005", new NaturalNumber(1), new Grade(1.7f), true);
        attempts.add(attemptIncluded);
        EntityMatcher.matchModules(modules, attempts, exams);
        assert modules.get(0).getAttempts()[0].equals(attemptIncluded);
    }

    @Test
    public void matchModulesAttemptNotIncluded() throws Exception {
        Attempt attemptIncluded = new Attempt("T3INF2006", new NaturalNumber(1), new Grade(1.7f), true);
        attempts.add(attemptIncluded);
        EntityMatcher.matchModules(modules, attempts, exams);
        assert modules.get(0).getAttempts().length == 0;
    }

    @Test
    public void matchModulesExamIncluded() throws Exception {
        Attempt attemptIncluded = new Attempt("T3INF2005", new NaturalNumber(1), new Grade(1.7f), true);
        attempts.add(attemptIncluded);
        Exam examIncluded = new Exam("Betriebssysteme", new Percentage(0.5f), new Rating(new Percentage(0.83f)), new NaturalNumber(1),"T3INF2005");
        exams.add(examIncluded);
        EntityMatcher.matchModules(modules, attempts, exams);
        assert attemptIncluded.getExams()[0].equals(examIncluded);
    }

    @Test
    public void matchModulesExamNotIncluded() throws Exception {
        Attempt attemptIncluded = new Attempt("T3INF2005", new NaturalNumber(1), new Grade(1.7f), true);
        attempts.add(attemptIncluded);
        Exam examNotIncluded = new Exam("Betriebssysteme", new Percentage(0.5f), new Rating(new Percentage(0.83f)), new NaturalNumber(2),"T3INF2005");
        exams.add(examNotIncluded);
        EntityMatcher.matchModules(modules, attempts, exams);
        assert attemptIncluded.getExams().length == 0;
    }

}
