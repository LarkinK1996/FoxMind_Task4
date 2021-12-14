package com.foxminded.division;

import com.foxminded.division.calculator.IntegerDivisionCalculator;
import com.foxminded.division.formatter.IntegerDivisionFormatter;
import com.foxminded.division.model.DivisionResult;

public class Application {
    public static void main(String[] args) {
        int divisor = 3587987;
        int divider = 9;
        IntegerDivisionCalculator calculator = new IntegerDivisionCalculator();
        IntegerDivisionFormatter formatter = new IntegerDivisionFormatter();
        DivisionResult result = calculator.calculateDivisionResult(divisor, divider);
        System.out.println(formatter.formatDivisionResult(result));

    }
}

