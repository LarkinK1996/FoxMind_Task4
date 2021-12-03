package com.foxminded.int_division;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Division myProgram = new Division();
        int dividend = 78945;
        int divider = 4;
        ArrayList<Step> steps = myProgram.fillTheListSteps(dividend, divider);

        DivisionVisualization divisionVisualization = new DivisionVisualization();
        divisionVisualization.visualization(steps, dividend);
    }
}
