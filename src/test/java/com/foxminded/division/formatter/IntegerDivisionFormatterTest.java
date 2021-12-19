package com.foxminded.division.formatter;

import com.foxminded.division.calculator.IntegerDivisionCalculator;
import com.foxminded.division.model.DivisionResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDivisionFormatterTest {

    IntegerDivisionCalculator calculator = new IntegerDivisionCalculator();
    IntegerDivisionFormatter formatter = new IntegerDivisionFormatter();
    private static final String NEWLINE = "\n";


    @Test
    void formatDivisionResult_shouldFormatDivisionResult_whenDividendMoreThanDivisor() {
        DivisionResult result = calculator.calculateDivisionResult(1234, 100);
        String formattedResult = formatter.formatDivisionResult(result);


        String expected = "_1234|100" + NEWLINE +
            " 100 |---" + NEWLINE +
            " --- |12" + NEWLINE +
            " _234" + NEWLINE +
            "  200" + NEWLINE +
            "  ---" + NEWLINE +
            "   34";

        assertEquals(expected, formattedResult);
    }

    @Test
    void formatDivisionResult_shouldPutCorrectNumberDashes_whenDivisorGreaterThanRemainder() {

        DivisionResult result = calculator.calculateDivisionResult(100, 20);
        String formattedResult = formatter.formatDivisionResult(result);
        boolean substringAvailability = formattedResult.contains(" 100|--");
        assertTrue(substringAvailability);

    }

    @Test
    void formatDivisionResult_shouldPutCorrectNumberDashes_whenDivisorLessThanRemainder() {

        DivisionResult result = calculator.calculateDivisionResult(100, 5);
        String formattedResult = formatter.formatDivisionResult(result);
        boolean substringAvailability = formattedResult.contains(" 10 |--");
        assertTrue(substringAvailability);

    }
}

