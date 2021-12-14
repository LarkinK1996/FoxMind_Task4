package com.foxminded.division.model;

public class DivisionStep {
    private int dividend;
    private int remainder;
    private int divisorMultiple;

    public DivisionStep(int dividend) {
        this.dividend = dividend;
    }

    public int getDividend() {
        return dividend;
    }

    public int getRemainder() {
        return remainder;
    }

    public int getDivisorMultiple() {
        return divisorMultiple;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public void setDivisorMultiple(int divisorMultiple) {
        this.divisorMultiple = divisorMultiple;
    }
}

