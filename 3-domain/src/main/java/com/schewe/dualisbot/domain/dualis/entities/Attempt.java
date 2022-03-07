package com.schewe.dualisbot.domain.dualis.entities;

import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;

public class Attempt {

    // ID
    private final String moduleId;
    private final NaturalNumber number;

    private final Grade grade;
    private final boolean passed;

    // Reference
    private Exam[] exams;

    public Attempt(String moduleId, NaturalNumber number, Grade grade, boolean passed) {
        this.moduleId = moduleId;
        this.number = number;
        this.grade = grade;
        this.passed = passed;
    }

    public String getModuleId() {
        return moduleId;
    }

    public NaturalNumber getNumber() {
        return number;
    }

    public Grade getGrade() {
        return grade;
    }

    public boolean isPassed() {
        return passed;
    }

    public Exam[] getExams() {
        return exams;
    }

    public void setExams(Exam[] exams) {
        this.exams = exams;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Attempt attempt = (Attempt) obj;
        return this.moduleId.equals(attempt.getModuleId())
                && this.number.equals(attempt.getNumber());
    }
}
