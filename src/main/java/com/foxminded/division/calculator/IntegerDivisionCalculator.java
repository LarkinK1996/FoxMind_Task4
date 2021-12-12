package com.foxminded.division.calculator;

import com.foxminded.division.model.DivisionResult;
import com.foxminded.division.model.DivisionStep;

import java.util.ArrayList;

public class IntegerDivisionCalculator {

    public DivisionResult calculateDivisionResult(int dividend, int divisor) {
        int[] dividendDigits = convertNumberToDigits(dividend);
        ArrayList<DivisionStep> divisionSteps = new ArrayList<>();
        int remainder = 0;

        for (int i = 0; i < dividendDigits.length; i++) {
            remainder = stickingTwoNumbers(remainder, dividendDigits[i]);
            if (remainder >= divisor) {
                divisionSteps.add(buildingStep(remainder, divisor));
                remainder = remainder % divisor;
            }
        }
        int quotient = dividend / divisor;
        return new DivisionResult(dividend, divisor, quotient, divisionSteps);
    }

    private int[] convertNumberToDigits(int convertible) {
        return Integer.toString(convertible).chars().map(c -> c - '0').toArray();
    }

    private int stickingTwoNumbers(int x, int y) {
        return x * 10 + y;
    }

    private DivisionStep buildingStep(int remainder, int divisor) {
        DivisionStep step = new DivisionStep(remainder, divisor);
        step.remainder = remainder % divisor;
        step.product = step.dividend - step.remainder;
        return step;
    }

}

