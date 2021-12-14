package com.foxminded.division.formatter;

import com.foxminded.division.calculator.IntegerDivisionCalculator;
import com.foxminded.division.model.DivisionResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDivisionFormatterTest {

    IntegerDivisionCalculator calculator = new IntegerDivisionCalculator();
    IntegerDivisionFormatter formatter = new IntegerDivisionFormatter();

    @Test
    void formatDivisionResult_shouldFindSubstrings_whenInputCorrectValues() {
        DivisionResult result = calculator.calculateDivisionResult(1234, 100);
        String formattedResult = formatter.formatDivisionResult(result);

        boolean substringAvailability1 = formattedResult.contains("_1234|100");
        assertTrue(substringAvailability1);
        boolean substringAvailability2 = formattedResult.contains(" 100 |---");
        assertTrue(substringAvailability2);
        boolean substringAvailability3 = formattedResult.contains(" --- |12");
        assertTrue(substringAvailability3);
        boolean substringAvailability4 = formattedResult.contains(" _234");
        assertTrue(substringAvailability4);
        boolean substringAvailability5 = formattedResult.contains("  200");
        assertTrue(substringAvailability5);
        boolean substringAvailability6 = formattedResult.contains("   34");
        assertTrue(substringAvailability6);
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

