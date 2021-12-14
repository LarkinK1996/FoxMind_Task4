package com.foxminded.division.model;

import java.util.ArrayList;

public class DivisionResult {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final ArrayList<DivisionStep> divisionSteps;

    public DivisionResult(int dividend, int divisor, int quotient, ArrayList<DivisionStep> divisionSteps,int remainder) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.divisionSteps = divisionSteps;
        this.remainder = remainder;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public ArrayList<DivisionStep> getSteps() {
        return divisionSteps;
    }

}

