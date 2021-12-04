package com.foxminded.division.formatter;

import com.foxminded.division.DivisionResult;
import com.foxminded.division.Step;

public class IntegerDivisionFormatter {
    private static final String SPACE = " ";
    private static final String UNDERLINE = "_";

    public void visualization(DivisionResult divisionResult) {


        int remainder = 0;
        System.out.println(divisionResult.dividend + "|" + divisionResult.steps.get(0).divisor);
        System.out.println(UNDERLINE);
        StringBuffer spaces = new StringBuffer();

        for (Step step : divisionResult.steps) {
            int dividendDigit = getCountsOfDigits(step.dividend);
            int dividerDigit = getCountsOfDigits(step.divisor);
            StringBuffer underlining = new StringBuffer();

            spaces.append(SPACE);
            for (int i = 0; i < dividendDigit; i++) {
                underlining.append(UNDERLINE);
            }

            System.out.println(spaces.toString() + step.dividend);
               System.out.println(spaces.toString() + step.localDividend + "   ");
            System.out.println(spaces.toString() + underlining);
            remainder = step.remainder;
        }
        System.out.println(spaces);
        System.out.println(remainder);
    }

    private int getCountsOfDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
}
