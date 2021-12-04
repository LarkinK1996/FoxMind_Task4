package com.foxminded.division;

public class Step {
    public int dividend;
    public int divisor;
    public int result;
    public int remainder;
    public int localDividend;


    public Step(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.result = dividend / divisor;
        this.remainder = dividend % divisor;
        this.localDividend = dividend - remainder;
    }


    @Override
    public String toString() {
        return "Step{" +
            "dividend=" + dividend +
            ", divisor=" + divisor +
            ", result=" + result +
            ", remainder=" + remainder +
            '}';
    }
}
