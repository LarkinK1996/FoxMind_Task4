package com.foxminded.division.model;

import java.util.ArrayList;

public class DivisionResult {
    public int dividend;
    public int divisor;
    public int result;
    public ArrayList<Step> steps;

    public DivisionResult(int dividend, int divisor, int result, ArrayList<Step> steps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.result = result;
        this.steps = steps;
    }
}
