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
    void formatDivisionResult_shouldThrowArithmeticException_whenDividerIsNull() {
        Integer refNull = null;
        assertThrows(NullPointerException.class, () -> formatter.formatDivisionResult(calculator.calculateDivisionResult(10, refNull)));
    }

    @Test
    void formatDivisionResult_shouldThrowArithmeticException_whenDividendIsNull() {
        Integer refNull = null;
        assertThrows(NullPointerException.class, () -> formatter.formatDivisionResult(calculator.calculateDivisionResult(refNull, 12)));
    }

    @Test
    void formatDivisionResult_shouldThrowArithmeticException_whenDividerIsZero() {
        assertThrows(ArithmeticException.class, () -> formatter.formatDivisionResult(calculator.calculateDivisionResult(10, 0)));
    }

    @Test
    void formatDivisionResult_shouldThrowArithmeticException_whenDividendIsZero() {
        DivisionResult divisionResult = calculator.calculateDivisionResult(0, 2000);
        String actual = formatter.formatDivisionResult(divisionResult);
        String expected = "_0|2000" + NEWLINE +
            " 0|----" + NEWLINE +
            " -|0" + NEWLINE +
            " 0";
        assertEquals(expected, actual);
    }

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
    void formatDivisionResult_shouldPutCorrectNumberDashes_whenDivisorGreaterThanQuotient() {

        DivisionResult result = calculator.calculateDivisionResult(100, 20);
        String formattedResult = formatter.formatDivisionResult(result);
        boolean substringAvailability = formattedResult.contains(" 100|--");
        assertTrue(substringAvailability);

    }

    @Test
    void formatDivisionResult_shouldPutCorrectNumberDashes_whenDivisorLessThanQuotient() {

        DivisionResult result = calculator.calculateDivisionResult(100, 5);
        String formattedResult = formatter.formatDivisionResult(result);
        boolean substringAvailability = formattedResult.contains(" 10 |--");
        assertTrue(substringAvailability);
    }

    @Test
    void formatDivisionResult_shouldReturnStringWithSeveralSteps_whenDividendIsLessThanZero() {

        DivisionResult divisionResult = calculator.calculateDivisionResult(642, -2);
        String actual = formatter.formatDivisionResult(divisionResult);
        String expected =
            "_642|-2" + NEWLINE +
                " 6  |---" + NEWLINE +
                " -  |-321" + NEWLINE +
                " _4" + NEWLINE +
                "  4" + NEWLINE +
                "  -" + NEWLINE +
                "  _2" + NEWLINE +
                "   2" + NEWLINE +
                "   -" + NEWLINE +
                "    0";
        assertEquals(expected, actual);
    }

    @Test
    void formatDivisionResult_shouldReturnDivisionResult_whenDividendHasZeros() {

        DivisionResult divisionResult = calculator.calculateDivisionResult(300010003, 2);
        String actual = formatter.formatDivisionResult(divisionResult);
        String expected =
            "_300010003|2" + NEWLINE +
                " 2        |---------" + NEWLINE +
                " -        |150005001" + NEWLINE +
                " _10" + NEWLINE +
                "  10" + NEWLINE +
                "  --" + NEWLINE +
                "  _10" + NEWLINE +
                "   10" + NEWLINE +
                "   --" + NEWLINE +
                "   _3" + NEWLINE +
                "    2" + NEWLINE +
                "    -" + NEWLINE +
                "     1";


        assertEquals(expected, actual);
    }

    @Test
    void formatDivisionResult_shouldReturnDivisionResult_whenDividendHasManyZeros() {

        DivisionResult divisionResult = calculator.calculateDivisionResult(30000003, 15);
        String actual = formatter.formatDivisionResult(divisionResult);
        String expected =
                "_30000003|15" + NEWLINE +
                " 30      |-------" + NEWLINE +
                " --      |2000000" + NEWLINE +
                " _3" + NEWLINE +
                "  0" + NEWLINE +
                "  -" + NEWLINE +
                "   3";

        assertEquals(expected, actual);
    }
}

