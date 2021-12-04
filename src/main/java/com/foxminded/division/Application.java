package com.foxminded.division;

import com.foxminded.division.formatter.IntegerDivisionFormatter;

public class Application {
    public static void main(String[] args) {
        int dividend = 78945;
        int divider = 4;
        IntegerDivisionCalculator myProgram = new IntegerDivisionCalculator();
        IntegerDivisionFormatter integerDivisionFormatter = new IntegerDivisionFormatter();
        DivisionResult divisionResult = myProgram.calculateDivisionResult(dividend, divider);


        integerDivisionFormatter.visualization(divisionResult);
    }
}
