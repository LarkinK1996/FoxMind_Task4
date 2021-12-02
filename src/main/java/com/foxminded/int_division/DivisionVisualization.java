package com.foxminded.int_division;

import java.util.ArrayList;

public class DivisionVisualization {

    void visualization(ArrayList<Step> steps, int dividend) {
        int remainder = 0;
        System.out.println(dividend + "|" + steps.get(0).divider);
        System.out.println("_");
        StringBuffer spaces = new StringBuffer();

        for (Step step : steps) {

            int dividendDigit = getCountsOfDigits(step.dividend);
            int dividerDigit = getCountsOfDigits(step.divider);
            StringBuffer underlining = new StringBuffer();
            spaces.append(" ");
            for(int i=0;i<dividendDigit;i++){
                underlining.append("_");
            }

            System.out.println(spaces.toString() + step.dividend);
            System.out.println("_");
            System.out.println(spaces.toString() + step.localDividend + "   ");
            System.out.println(spaces.toString() + underlining);
            remainder = step.remainder;
        }
        System.out.println(spaces);
        System.out.println(remainder);
    }

    private int getCountsOfDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
}
