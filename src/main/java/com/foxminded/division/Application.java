package com.foxminded.division;

import com.foxminded.division.calculator.IntegerDivisionCalculator;
import com.foxminded.division.formatter.IntegerDivisionFormatter;
import com.foxminded.division.model.DivisionResult;
import com.foxminded.division.model.DivisionStep;

public class Application {
    public static void main(String[] args) {
        int divider = 0;
        int divisor = 42;
        IntegerDivisionCalculator calculator = new IntegerDivisionCalculator();
        IntegerDivisionFormatter formatter = new IntegerDivisionFormatter();
        DivisionResult result = calculator.calculateDivisionResult(divider, divisor);
        System.out.println(formatter.formatDivisionResult(result));
        System.out.println(result);
    }
}

