package com.foxminded.division.model;

import java.util.ArrayList;

public class DivisionResult {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final ArrayList<DivisionStep> divisionSteps;

    public DivisionResult(int dividend, int divisor, int quotient, ArrayList<DivisionStep> divisionSteps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.divisionSteps = divisionSteps;
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

    public ArrayList<DivisionStep> getSteps() {
        return divisionSteps;
    }
}

