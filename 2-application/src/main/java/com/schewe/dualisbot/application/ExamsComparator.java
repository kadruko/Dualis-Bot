package com.schewe.dualisbot.application;

import com.schewe.dualisbot.domain.dualis.entities.Exam;

import java.util.ArrayList;
import java.util.List;

public class ExamsComparator {

    private final List<Exam> oldExams;
    private final List<Exam> newExams;

    public ExamsComparator(List<Exam> oldExams, List<Exam> newExams){
        this.oldExams = oldExams;
        this.newExams = newExams;
    }

    public List<Exam> getDifference(){
        List<Exam> difference = new ArrayList<>();
        for(Exam newExam : newExams){
            boolean isNewExam = true;
            for(Exam oldExam : oldExams){
                if (newExam.getName().equals(oldExam.getName())) {
                    isNewExam = false;
                    break;
                }
            }
            if(isNewExam)
                difference.add(newExam);
        }
        return difference;
    }

}
