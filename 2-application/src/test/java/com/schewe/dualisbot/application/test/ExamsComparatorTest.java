package com.schewe.dualisbot.application.test;

import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;
import com.schewe.dualisbot.abstraction.valueobjects.Percentage;
import com.schewe.dualisbot.application.ExamsComparator;
import com.schewe.dualisbot.domain.dualis.entities.Exam;
import com.schewe.dualisbot.domain.dualis.valueobjects.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExamsComparatorTest {

    List<Exam> oldExams;
    Exam oldExam;
    List<Exam> newExams;

    @BeforeEach
    public void beforeAll() throws Exception {
        oldExams = new ArrayList<>();
        oldExam = new Exam("Betriebssysteme", new Percentage(0.5f), new Rating(new Percentage(0.83f)), new NaturalNumber(1),"T3INF2005");
        oldExams.add(oldExam);
        newExams = new ArrayList<>();
        newExams.add(oldExam);
    }

    @Test
    public void getDifferenceExisting() throws Exception {
        Exam newExam = new Exam("Rechnerarchitektur", new Percentage(0.5f), new Rating(new Percentage(0.92f)), new NaturalNumber(1),"T3INF2005");
        newExams.add(newExam);
        ExamsComparator examsComparator = new ExamsComparator(oldExams, newExams);
        List<Exam> difference = examsComparator.getDifference();
        assert difference.size() == 1;
        assert difference.get(0).equals(newExam);
    }

    @Test
    public void getDifferenceNotExisting() {
        ExamsComparator examsComparator = new ExamsComparator(oldExams, newExams);
        List<Exam> difference = examsComparator.getDifference();
        assert difference.size() == 0;
    }

}
