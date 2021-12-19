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
        if (divisionResult.getDividend() != 0) {
            return createDivisionHeader(divisionResult) + createDivisionBody(divisionResult);
        } else
            return "_0|" + divisionResult.getDivisor() + NEWLINE + " 0|" + DASH.repeat(calculateNumberLength(divisionResult.getDivisor())) + NEWLINE + " -|0";
    }

    private String createDivisionHeader(DivisionResult divisionResult) {
        int firstStepDivisorMultiple = divisionResult.getSteps().get(0).getDivisorMultiple();
        int spaceAmountToEndLine = calculateNumberLength(divisionResult.getDividend()) - calculateNumberLength(firstStepDivisorMultiple);
        int dashAmountBelowDivisorMultiple = calculateNumberLength(firstStepDivisorMultiple);
        int dashAmountInAnswer = Math.max(calculateNumberLength(divisionResult.getQuotient()), calculateNumberLength(divisionResult.getDivisor()));

        return MINUS + divisionResult.getDividend()
            + VERTICALLINE
            + divisionResult.getDivisor()
            + NEWLINE
            + SPACE + firstStepDivisorMultiple
            + SPACE.repeat(spaceAmountToEndLine)
            + VERTICALLINE
            + DASH.repeat(dashAmountInAnswer)
            + NEWLINE + SPACE
            + DASH.repeat(dashAmountBelowDivisorMultiple)
            + SPACE.repeat(spaceAmountToEndLine)
            + VERTICALLINE + divisionResult.getQuotient();
    }

    private String createDivisionBody(DivisionResult divisionResult) {
        StringBuilder result = new StringBuilder();
        int indent = 2;
        int lastStep = divisionResult.getSteps().size() - 1;

        for (int i = 1; i < divisionResult.getSteps().size(); i++, indent++) {
            result.append(formatStep(divisionResult.getSteps().get(i), indent));
        }
        result.append(NEWLINE);
        result.append(SPACE.repeat(indent));
        result.append(divisionResult.getSteps().get(lastStep).getRemainder());

        return result.toString();
    }

    private String formatStep(DivisionStep step, int indent) {
        int dividendLength = calculateNumberLength(step.getDividend());

        return NEWLINE
            + SPACE.repeat(indent - 1)
            + MINUS + step.getDividend()
            + NEWLINE
            + SPACE.repeat(indent)
            + step.getDivisorMultiple()
            + NEWLINE
            + SPACE.repeat(indent)
            + DASH.repeat(dividendLength);
    }

    private int calculateNumberLength(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
}

