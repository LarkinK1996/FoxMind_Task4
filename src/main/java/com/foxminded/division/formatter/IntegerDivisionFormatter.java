package com.foxminded.division.formatter;

import com.foxminded.division.DivisionResult;

public class IntegerDivisionFormatter {
    private static final String SPACE = " ";
    private static final String MINUS = "_";
    private static final String NEWLINE = "\n";
    private static final String DASH = "-";
    private static final String VERTICALLINE = "|";

    public String formatDivisionResult(DivisionResult divisionResult) {
        String heading = createHeading(divisionResult);
        return heading;
    }

    private int getCountsOfDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    private String createHeading(DivisionResult divisionResult) {
        StringBuilder underlineString = new StringBuilder();
        StringBuilder spaces = new StringBuilder();
        StringBuilder dashs = new StringBuilder();
        int numberCharactersDividend = getCountsOfDigits(divisionResult.dividend);
        int numberCharacterDivisor = getCountsOfDigits(divisionResult.divisor);


        for (int i = 0; i < numberCharactersDividend; i++) {
            underlineString.append(DASH);
        }

        for (int i = 0; i < numberCharactersDividend - numberCharacterDivisor; i++) {
            spaces.append(SPACE);
        }
       // for (int i=0;i< ){

            //}
        String heading = MINUS + divisionResult.dividend + VERTICALLINE + divisionResult.steps.get(0).divisor + NEWLINE +
            SPACE + divisionResult.steps.get(0).product + spaces + VERTICALLINE + underlineString + NEWLINE +
            SPACE + DASH + spaces + VERTICALLINE + divisionResult.result;

        return heading;
    }
}
