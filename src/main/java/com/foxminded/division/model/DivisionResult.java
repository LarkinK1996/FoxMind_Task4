package com.foxminded.division.model;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionResult result = (DivisionResult) o;
        return dividend == result.dividend && divisor == result.divisor && quotient == result.quotient && Objects.equals(divisionSteps, result.divisionSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, quotient, divisionSteps);
    }

    @Override
    public String toString() {
        return "DivisionResult{" +
            "dividend=" + dividend +
            ", divisor=" + divisor +
            ", quotient=" + quotient + '\n' +
            ", divisionSteps=" + divisionSteps +
            '}';
    }
}

