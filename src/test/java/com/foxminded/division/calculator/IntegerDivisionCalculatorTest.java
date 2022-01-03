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
    void calculateDivisionResult_shouldReturnDivisionResult_whenDividendIsZero() {
        DivisionResult actual = calculator.calculateDivisionResult(0, 1);
        DivisionResult expected = new DivisionResult(0, 1, 0, new ArrayList<>());

        assertEquals(expected, actual);
    }


    @Test
    void calculateDivisionResult_shouldReturnDivisionResult_whenDividendMoreThanDivisor() {
        DivisionResult actual = calculator.calculateDivisionResult(123, 11);
        ArrayList<DivisionStep> expectedSteps = new ArrayList<DivisionStep>();
        expectedSteps.add(new DivisionStep(12, 1, 11));
        expectedSteps.add(new DivisionStep(13, 2, 11));
        DivisionResult expected = new DivisionResult(123, 11, 11, expectedSteps);

        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionResult_shouldReturnDivisionResult_whenDividendLessThanDivisor() {
        DivisionResult actual = calculator.calculateDivisionResult(2, 4);
        ArrayList<DivisionStep> expectedSteps = new ArrayList<DivisionStep>();
        DivisionResult expected = new DivisionResult(2, 4, 0, expectedSteps);

        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionResult_shouldReturnDivisionResult_whenDividendIsNegative() {
        DivisionResult actual = calculator.calculateDivisionResult(-22, 4);
        ArrayList<DivisionStep> expectedSteps = new ArrayList<>();
        expectedSteps.add(new DivisionStep(22, 2, 20));
        DivisionResult expected = new DivisionResult(22, 4, 5, expectedSteps);

        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionResult_shouldReturnDivisionResult_whenDividendHasZeros() {
        DivisionResult actual = calculator.calculateDivisionResult(200046, 2);
        ArrayList<DivisionStep> expectedSteps = new ArrayList<>();

        expectedSteps.add(new DivisionStep(2, 0, 2));
        expectedSteps.add(new DivisionStep(4, 0, 4));
        expectedSteps.add(new DivisionStep(6, 0, 6));
        DivisionResult expected = new DivisionResult(200046, 2, 100023, expectedSteps);

        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionResult_shouldReturnDivisionResult_whenDividendHasManyZeros() {
        DivisionResult actual = calculator.calculateDivisionResult(30000003, 15);
        ArrayList<DivisionStep> expectedSteps = new ArrayList<>();

        expectedSteps.add(new DivisionStep(30, 0, 30));
        expectedSteps.add(new DivisionStep(3, 3, 0));
        DivisionResult expected = new DivisionResult(30000003, 15, 2000000, expectedSteps);

        assertEquals(expected, actual);
    }
}

