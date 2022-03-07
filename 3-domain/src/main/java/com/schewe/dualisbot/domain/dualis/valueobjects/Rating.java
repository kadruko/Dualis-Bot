package com.schewe.dualisbot.domain.dualis.valueobjects;

import com.schewe.dualisbot.abstraction.valueobjects.Grade;
import com.schewe.dualisbot.abstraction.valueobjects.Percentage;
import com.schewe.dualisbot.domain.dualis.enumerations.RatingType;

public final class Rating {

    private final RatingType ratingType;
    private final  float rating;

    public Rating(final Percentage percentage){
        ratingType = RatingType.PERCENTAGE;
        rating = percentage.getPercentage();
    }

    public Rating(final Grade grade){
        ratingType = RatingType.GRADE;
        rating = grade.getGrade();
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int hashCode() {
        return (int) (rating * 100);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Rating rating = (Rating) obj;
        return this.rating == rating.getRating();
    }

}
