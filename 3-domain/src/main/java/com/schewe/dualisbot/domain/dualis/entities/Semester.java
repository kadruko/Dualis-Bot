package com.schewe.dualisbot.domain.dualis.entities;

import com.schewe.dualisbot.domain.dualis.enumerations.SemesterType;

import java.time.Year;

public class Semester {

    private final Year year;
    private final SemesterType semesterType;

    public Semester(Year year, SemesterType semesterType) {
        this.year = year;
        this.semesterType = semesterType;
    }

    public SemesterType getSemesterType() {
        return semesterType;
    }

    public Year getYear() {
        return year;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Semester semester = (Semester) obj;
        return this.year.equals(semester.getYear())
                && this.semesterType == semester.getSemesterType();
    }
}
