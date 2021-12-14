package com.foxminded.division.formatter;

import com.foxminded.division.model.DivisionResult;
import com.foxminded.division.model.DivisionStep;

public class IntegerDivisionFormatter {
    private static final String SPACE = " ";
    private static final String MINUS = "_";
    private static final String NEWLINE = "\n";
    private static final String DASH = "-";
    private static final String VERTICALLINE = "|";

    public String formatDivisionResult(DivisionResult divisionResult) {
        return createDivisionHeader(divisionResult) + createDivisionBody(divisionResult);
    }

    private String createDivisionHeader(DivisionResult divisionResult) {
        int spaceAmount = calculateNumberLength(divisionResult.getDividend()) - calculateNumberLength(divisionResult.getSteps().get(0).getDivisorMultiple());
        int dashAmount = calculateNumberLength(divisionResult.getSteps().get(0).getDivisorMultiple());
        int dashAmountInAnswer;
        if (divisionResult.getQuotient() > divisionResult.getDivisor()) {
            dashAmountInAnswer = calculateNumberLength(divisionResult.getQuotient());
        } else
            dashAmountInAnswer = calculateNumberLength(divisionResult.getDivisor());
        if (divisionResult.getQuotient() < 0) {
            dashAmountInAnswer++;
        }

        String line1 = (MINUS + divisionResult.getDividend()
            + VERTICALLINE
            + divisionResult.getDivisor() + NEWLINE);

        String line2 = (SPACE + divisionResult.getSteps().get(0).getDivisorMultiple() +
            SPACE.repeat(spaceAmount)
            + VERTICALLINE
            + DASH.repeat(dashAmountInAnswer)
            + NEWLINE);
        String line3 = (SPACE +
            DASH.repeat(dashAmount)
            + SPACE.repeat(spaceAmount)
            + VERTICALLINE + divisionResult.getQuotient());

        return line1 + line2 + line3;
    }

    private String createDivisionBody(DivisionResult divisionResult) {
        StringBuilder result = new StringBuilder();
        int indent = 2;

        for (int i = 1; i < divisionResult.getSteps().size(); i++, indent++) {
            result.append(formatStep(divisionResult.getSteps().get(i), indent));
        }
        result.append(NEWLINE);
        result.append(SPACE.repeat(indent));
        result.append(divisionResult.getRemainder());

        return result.toString();
    }

    private int calculateNumberLength(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    private String formatStep(DivisionStep step, int indent) {
        StringBuilder result = new StringBuilder();
        int dividendLength = calculateNumberLength(step.getDividend());

        result.append(NEWLINE);
        result.append(SPACE.repeat(indent - 1));
        result.append(MINUS);
        result.append(step.getDividend());

        result.append(NEWLINE);
        result.append(SPACE.repeat(indent));
        result.append(step.getDivisorMultiple());

        result.append(NEWLINE);
        result.append(SPACE.repeat(indent));
        result.append(DASH.repeat(dividendLength));

        return result.toString();
    }
}

