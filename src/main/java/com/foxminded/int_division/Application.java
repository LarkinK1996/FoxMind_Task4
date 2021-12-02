package com.foxminded.int_division;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Division myProgram = new Division();
        int[] arr = {7, 8, 9, 4, 5};
        int divider = 4;

        ArrayList<Step> steps = new ArrayList<>();

        steps = myProgram.fillTheListSteps(arr, divider);

        for (Step step : steps ){
            System.out.println(step.toString());
        }

    }
}
