package com.schewe.dualisbot.domain.dualis.entities;

import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.domain.dualis.valueobjects.Credits;

public class Module {

    // ID
    private final String moduleId;

    private final String moduleName;
    private final Semester semester;
    private final Credits credits;
    private final boolean passed;
    private final Grade grade;

    // Reference
    private Attempt[] attempts;

    public Module(String moduleId, String moduleName, Semester semester, Credits credits, boolean passed, Grade grade) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.semester = semester;
        this.credits = credits;
        this.passed = passed;
        this.grade = grade;
    }

    public String getModuleId() {
        return moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public Semester getSemester() {
        return semester;
    }

    public Credits getCredits() {
        return credits;
    }

    public boolean isPassed() {
        return passed;
    }

    public Grade getGrade() {
        return grade;
    }

    public Attempt[] getAttempts() {
        return attempts;
    }

    public void setAttempts(Attempt[] attempts) {
        this.attempts = attempts;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Module module = (Module) obj;
        return this.moduleId.equals(module.getModuleId());
    }
}
