package com.schewe.dualisbot.abstraction.valueobjects;

public final class NaturalNumber {

    private final int number;

    public NaturalNumber(int number) throws Exception {
        if(number >= 0)
            this.number = number;
        else
            throw new Exception("A value for a natrual number has to be positive.");
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
        final NaturalNumber naturalNumber = (NaturalNumber) obj;
        return this.number == naturalNumber.getNumber();
    }
}
