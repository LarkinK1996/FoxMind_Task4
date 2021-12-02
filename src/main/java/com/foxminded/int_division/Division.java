package com.foxminded.int_division;

import java.util.ArrayList;

public class Division {

    int remainder;
    ArrayList<Step> steps = new ArrayList<>();

    public ArrayList<Step> fillTheListSteps(int[] dividend, int divider) {
        ArrayList<Step> steps = new ArrayList<>();
        Memorizer memorizer = new Memorizer();

        for (int i = 0; i < dividend.length; i++) {
            memorizer.add(dividend[i]);
            if (memorizer.value >= (divider)) {
                Step step = new Step(memorizer.value, divider);
                steps.add(step);
                memorizer.setValue(step.remainder);
            }
        }

        return steps;


    }
}