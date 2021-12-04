package com.foxminded.division;

import com.foxminded.division.formatter.IntegerDivisionFormatter;

public class Application {
    public static void main(String[] args) {
        int divisor = 7894522;
        int divider = 400;
        IntegerDivisionCalculator myProgram = new IntegerDivisionCalculator();
        IntegerDivisionFormatter integerDivisionFormatter = new IntegerDivisionFormatter();
        DivisionResult divisionResult = myProgram.calculateDivisionResult(divisor, divider);


        //integerDivisionFormatter.formatDivisionResult(divisionResult);
        divisionResult = myProgram.calculateDivisionResult(divisor, divider);

        for (Step step : myProgram.calculateDivisionResult(divisor, divider).steps) {
            System.out.println(step.toString());
        }
        System.out.println( integerDivisionFormatter.formatDivisionResult(divisionResult));
    }
}
