package com.foxminded.int_division;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        Division myProgram = new Division();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(7);
        input.add(8);
        input.add(9);
        input.add(4);
        input.add(5);
        int divider = 4;
        myProgram.division(input, divider);

        System.out.println(myProgram.result);

    }
}
