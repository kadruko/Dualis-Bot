package com.schewe.dualisbot.domain.dualis.valueobjects;

public final class Credits{

    private final int number;

    public Credits(final int number) throws Exception {
        if(number >= 0 && number <= 210)
            this.number = number;
        else
            throw new Exception("A value for credits has to be between 0 and 210.");
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Credits credits = (Credits) obj;
        return number == credits.getNumber();
    }

}
