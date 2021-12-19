package com.foxminded.division.calculator;

import com.foxminded.division.model.DivisionResult;
import com.foxminded.division.model.DivisionStep;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDivisionCalculatorTest {
    IntegerDivisionCalculator calculator = new IntegerDivisionCalculator();

    @Test
    void calculateDivisionResult_shouldThrowException_whenDivisorIsZero() {
        int dividend = 1;
        int divisor = 0;

        assertThrows(ArithmeticException.class, () -> calculator.calculateDivisionResult(dividend, divisor));
    }

    @Test
    void calculateDivisionResult_shouldThrowException_whenDividendIsZero() {
        int dividend = 0;
        int divisor = 1;
        DivisionResult actual = calculator.calculateDivisionResult(dividend, divisor);
        DivisionResult expected = new DivisionResult(0, 1, 0, new ArrayList<>());
        assertEquals(expected,actual);
    }


    @Test
    void calculateDivisionResult_shouldDivideCorrectly_whenDividendMoreThanDivisor() {
        DivisionResult actual = calculator.calculateDivisionResult(123, 11);
        ArrayList<DivisionStep> expectedSteps = new ArrayList<DivisionStep>();
        expectedSteps.add(new DivisionStep(12, 1, 11));
        expectedSteps.add(new DivisionStep(13, 2, 11));
        DivisionResult expected = new DivisionResult(123, 11, 11, expectedSteps);

        assertEquals(expected, actual);
    }

   /* @Test
    void calculateDivisionResult_shouldDivideCorrectly_whenDividendLessThanDivisor() {
        DivisionResult actual = calculator.calculateDivisionResult(4, 2);
        ArrayList<DivisionStep> expectedSteps = new ArrayList<DivisionStep>();
        expectedSteps.add(new DivisionStep(12, 1, 11));
        expectedSteps.add(new DivisionStep(13, 2, 11));
        DivisionResult expected = new DivisionResult(123, 11, 11, expectedSteps);

        assertEquals(expected, actual);
    }*/
}

