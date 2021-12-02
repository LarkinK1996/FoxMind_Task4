package com.foxminded.int_division;

public class Step {
    int dividend;
    int divider;
    int result;
    int remainder;
    int localDividend;


    public Step(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
        this.result = dividend / divider;
        this.remainder = dividend % divider;
        this.localDividend = dividend - remainder;
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
