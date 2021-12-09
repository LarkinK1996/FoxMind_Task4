package com.foxminded.division.formatter;

import com.foxminded.division.model.DivisionResult;

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

    private String createHeading(DivisionResult divisionResult) {
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        String answer;

        line1.append(MINUS)
            .append(divisionResult.dividend)
            .append(VERTICALLINE)
            .append(divisionResult.steps.get(0).divisor)
            .append(NEWLINE);

        line2.append(SPACE)
            .append(divisionResult.steps.get(0).product)
            .append(new String(new char[deltaDigits(divisionResult.dividend, divisionResult.steps.get(0).product)]).replace("\0", SPACE))
            .append(VERTICALLINE)
            .append(new String(new char[getCountsOfDigits(divisionResult.result)]).replace("\0", DASH))
            .append(NEWLINE);

        line3.append(SPACE)
            .append(new String(new char[getCountsOfDigits(divisionResult.steps.get(0).product)]).replace("\0", DASH))
            .append(new String(new char[deltaDigits(divisionResult.dividend, divisionResult.steps.get(0).product)]).replace("\0", SPACE))
            .append(VERTICALLINE)
            .append(divisionResult.result);

        answer = line1.toString() + line2.toString() + line3.toString();
        return answer;
    }

    private int getCountsOfDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    private int deltaDigits(int x, int y) {
        return getCountsOfDigits(x) - getCountsOfDigits(y);
    }
}

