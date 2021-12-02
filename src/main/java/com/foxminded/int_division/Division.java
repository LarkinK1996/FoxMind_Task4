package com.foxminded.int_division;

import java.util.ArrayList;

public class Division {

    int remainder;
    ArrayList<Step> steps = new ArrayList<>();

    public ArrayList<Step> fillTheListSteps(int dividends, int divider) {
        int[] dividend = transformation(dividends);
        ArrayList<Step> steps = new ArrayList<>();
        Memorizer memorizer = new Memorizer();

        for (int i = 0; i < dividend.length; i++) {
            memorizer.setValue(dividend[i]);
            if (memorizer.value >= divider) {
                Step step = new Step(memorizer.value, divider);
                steps.add(step);
                memorizer.value = step.remainder;
            }
        }

        return steps;
    }

    private int[] transformation(int convertible) {
        int[] digits = Integer.toString(convertible).chars().map(c -> c - '0').toArray();
        return digits;
    }
}
