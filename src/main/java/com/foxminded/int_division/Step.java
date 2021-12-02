package com.foxminded.int_division;

public class Step {
    int dividend;
    int divider;
    int result;
    int remainder;

    public Step(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
        result = dividend / divider;
        remainder = dividend % divider;
    }

    @Override
    public String toString() {
        return "Step{" +
                "dividend=" + dividend +
                ", divider=" + divider +
                ", result=" + result +
                ", remainder=" + remainder +
                '}';
    }
}
