package com.foxminded.division.calculator;

import com.foxminded.division.model.DivisionResult;
import com.foxminded.division.model.Step;

import java.util.ArrayList;

public class IntegerDivisionCalculator {

    int remainder;

    public DivisionResult calculateDivisionResult(int dividend, int divisor) {
        int[] arrayOfDividend = convertingNumberToArray(dividend);
        ArrayList<Step> steps = new ArrayList<>();
        int remainder = 0;

        for (int i = 0; i < arrayOfDividend.length; i++) {
            remainder = adhesion(remainder, arrayOfDividend[i]);
            if (remainder >= divisor) {
                Step step = new Step(remainder, divisor);
                step.remainder = remainder % divisor;
                step.product = step.dividend - step.remainder;
                steps.add(step);
                remainder = step.remainder;
            }
        }
        int quotient = dividend / divisor;
        DivisionResult result = new DivisionResult(dividend, divisor, quotient, steps);

        return result;
    }

    private int[] convertingNumberToArray(int convertible) {
        return Integer.toString(convertible).chars().map(c -> c - '0').toArray();
    }

    private int adhesion(int x, int y) {
        int z;
        z = x * 10 + y;
        return z;
    }
}
