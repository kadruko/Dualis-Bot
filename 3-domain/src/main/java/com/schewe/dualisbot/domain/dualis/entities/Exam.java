package com.schewe.dualisbot.domain.dualis.entities;

import com.schewe.dualisbot.abstraction.valueobjects.NaturalNumber;
import com.schewe.dualisbot.abstraction.valueobjects.Percentage;
import com.schewe.dualisbot.domain.dualis.valueobjects.Rating;

public class Exam {

    // ID
    private final String moduleId;
    private final NaturalNumber attemptNumber;
    private final String name;

    private final Percentage weighting;
    private final Rating rating;

    public Exam(String name, Percentage weighting, Rating rating, NaturalNumber attemptNumber, String moduleId) {
        this.name = name;
        this.weighting = weighting;
        this.rating = rating;
        this.attemptNumber = attemptNumber;
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public Percentage getWeighting() {
        return weighting;
    }

    public Rating getRating() {
        return rating;
    }

    public NaturalNumber getAttemptNumber() {
        return attemptNumber;
    }

    public String getModuleId(){
        return moduleId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Exam exam = (Exam) obj;
        return this.moduleId.equals(exam.getModuleId())
                && this.attemptNumber.equals(exam.getAttemptNumber())
                && this.name.equals(exam.getName());
    }
}
