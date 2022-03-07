package com.schewe.dualisbot.abstraction.valueobjects;

public final class Percentage {

    private final float percentage;

    public Percentage(final float percentage) throws Exception {
        if(percentage >= 0 && percentage <= 1)
            this.percentage = percentage;
        else
            throw new Exception("A value for a percentage has to be between 0 and 1.");
    }

    public float getPercentage() {
        return percentage;
    }

    @Override
    public int hashCode() {
        return (int) (percentage * 100);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Percentage percentage = (Percentage) obj;
        return this.percentage == percentage.getPercentage();
    }
}
