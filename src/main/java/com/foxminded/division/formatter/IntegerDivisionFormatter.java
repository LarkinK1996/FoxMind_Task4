package com.foxminded.division.formatter;

import com.foxminded.division.model.DivisionResult;
import com.foxminded.division.model.DivisionStep;

import java.util.ArrayList;

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
        String line1 = (MINUS + divisionResult.getDividend() + VERTICALLINE
            + divisionResult.getDivisor() + NEWLINE);
        String line2 = (SPACE + divisionResult.getSteps().get(0).getDivisorMultiple() +
            new String(new char[calculateNumberLength(divisionResult.getDividend()) - calculateNumberLength(divisionResult.getSteps().get(0).getDivisorMultiple())]).replace("\0", SPACE)
            + VERTICALLINE
            + new String(new char[calculateNumberLength(divisionResult.getQuotient())]).replace("\0", DASH)
            + NEWLINE);
        String line3 = (SPACE +
            new String(new char[calculateNumberLength(divisionResult.getSteps().get(0).getDivisorMultiple())]).replace("\0", DASH)
            + new String(new char[calculateNumberLength(divisionResult.getDividend()) - calculateNumberLength(divisionResult.getSteps().get(0).getDivisorMultiple())]).replace("\0", SPACE)
            + VERTICALLINE + divisionResult.getQuotient());

        return line1 + line2 + line3;
    }

    public String createDivisionBody(DivisionResult divisionResult) {

        StringBuilder result = new StringBuilder();
        ArrayList<DivisionStep> divisionSteps = divisionResult.getSteps();
        int indent = 1;

        for (int i = 1; i < divisionResult.getSteps().size(); i++, indent++) {
            result.append(NEWLINE);
            result.append((new String(new char[indent - 1]).replace("\0", SPACE)));
            result.append(MINUS);
            result.append(divisionSteps.get(i).getDividend());

            result.append(NEWLINE);
            result.append((new String(new char[indent]).replace("\0", SPACE)));
            result.append(divisionSteps.get(i).getDivisorMultiple());

            result.append(NEWLINE);
            result.append((new String(new char[indent]).replace("\0", SPACE)));
            result.append((new String(new char[calculateNumberLength(divisionSteps.get(i).getDividend())]).replace("\0", DASH)));
        }
        result.append(NEWLINE);
        result.append((new String(new char[indent]).replace("\0", SPACE)));
        result.append(divisionResult.getDividend() % divisionResult.getDivisor());

        return result.toString();
    }

    private int calculateNumberLength(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

//    private String formatStep(DivisionStep step, int indent) {

    //}
}

