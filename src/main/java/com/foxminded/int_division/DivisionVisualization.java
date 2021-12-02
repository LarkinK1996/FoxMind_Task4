package com.foxminded.int_division;

import java.util.ArrayList;

public class DivisionVisualization {

    void visualization(ArrayList<Step> steps, int dividend) {
        System.out.println(dividend + "|" + steps.get(0).divider);
        for (Step step : steps) {
            int numberDigit = getCountsOfDigits(step.dividend);
            System.out.println("_" + step.dividend + "   ");
            System.out.println(step.remainder + "   ");
        }
    }
    private int getCountsOfDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
}
