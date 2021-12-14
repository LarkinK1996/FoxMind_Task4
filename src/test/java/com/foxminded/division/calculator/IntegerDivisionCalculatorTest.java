package com.foxminded.division.calculator;

import com.foxminded.division.model.DivisionResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDivisionCalculatorTest {
    IntegerDivisionCalculator calculator = new IntegerDivisionCalculator();


    @Test
    void calculateDivisionResult_shouldThrowException_whenInputZero() {
        int dividend = 1;
        int divisor = 0;
        assertThrows(ArithmeticException.class, () -> calculator.calculateDivisionResult(dividend, divisor));
    }


    @Test
    void calculateDivisionResult_shouldDivideCorrectly_whenInputCorrectValues() {
        DivisionResult result = calculator.calculateDivisionResult(123, 11);
        int expectedQuotient = 11;
        int expectedRemainder = 2;
        int expectedFirstStepDividend = 12;
        int expectedFirstStepRemainder = 1;
        int expectedSecondStepDividend = 13;
        int expectedStepSize = 2;

        assertEquals(expectedQuotient, result.getQuotient());
        assertEquals(expectedRemainder, result.getRemainder());
        assertEquals(expectedFirstStepDividend, result.getSteps().get(0).getDividend());
        assertEquals(expectedFirstStepRemainder, result.getSteps().get(0).getRemainder());
        assertEquals(expectedSecondStepDividend, result.getSteps().get(1).getDividend());
        assertEquals(expectedStepSize, result.getSteps().size());
    }

    @Test
    void calculateDivisionResult_shouldDivideCorrectly_whenInputNegativeDivisor() {
        DivisionResult result = calculator.calculateDivisionResult(4, -2);
        int expectedQuotient = -2;
        assertEquals(expectedQuotient, result.getQuotient());
    }
}

