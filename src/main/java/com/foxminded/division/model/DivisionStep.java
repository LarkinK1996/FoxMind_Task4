package com.foxminded.division.model;

public class DivisionStep {
    public int dividend;
    public int divisor;
    public int remainder;
    public int product;

    public DivisionStep(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    @Override
    public String toString() {
        return "Step{" +
            "dividend=" + dividend +
            ", divisor=" + divisor +
            ", remainder=" + remainder +
            ", product=" + product +
            '}';
    }
}

