package com.schewe.dualisbot.abstraction.valueobjects;

public final class Grade {

    private final float grade;

    public Grade(final float grade) throws Exception {
        if(grade >= 0 && grade <= 6)
            this.grade = grade;
        else
            throw new Exception("A value for a grade has to be between 1.0 and 6.0.");
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public int hashCode() {
        return (int) (grade * 10);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Grade grade = (Grade) obj;
        return this.grade == grade.getGrade();
    }

}
