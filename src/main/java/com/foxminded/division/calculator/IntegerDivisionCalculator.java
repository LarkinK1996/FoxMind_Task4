package com.foxminded.division.calculator;

import com.foxminded.division.model.DivisionResult;
import com.foxminded.division.model.DivisionStep;

import java.util.ArrayList;

public class IntegerDivisionCalculator {

    public DivisionResult calculateDivisionResult(int dividend, int divisor) {
        int[] dividendDigits = convertNumberToDigits(dividend);
        ArrayList<DivisionStep> divisionSteps = new ArrayList<>();
        int remainder = 0;

        for (int localDividend : dividendDigits) {
            remainder = combineNumbers(remainder, localDividend);
            if (remainder >= divisor) {
                divisionSteps.add(buildingStep(remainder, divisor));
                remainder = remainder % divisor;
            }
        }
        int quotient = dividend / divisor;
        remainder = dividend % divisor;
        return new DivisionResult(dividend, divisor, quotient, divisionSteps, remainder);
    }

    private int[] convertNumberToDigits(int convertible) {
        return Integer.toString(convertible).chars().map(c -> c - '0').toArray();
    }

    private int combineNumbers(int x, int y) {
        return x * 10 + y;
    }

    private DivisionStep buildingStep(int remainder, int divisor) {
        DivisionStep step = new DivisionStep(remainder);
        step.setRemainder(remainder % divisor);
        step.setDivisorMultiple(step.getDividend() - step.getRemainder());
        return step;
    }

}

