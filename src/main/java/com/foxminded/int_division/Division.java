package com.foxminded.int_division;

import java.util.ArrayList;

public class Division {

    int remainder;
    ArrayList<Step> steps = new ArrayList<>();

    public void division(ArrayList<Integer> dividend, int divider) {
        if (dividend.get(0) >= divider) {
            if (dividend.size() > 1) {
                remainder = dividend.get(0) % divider;
                steps.add(new Step(dividend.get(0), divider));
                rewriting(dividend, remainder);
                division(dividend, divider);
            }

        } else if (dividend.get(0) < divider) {
            if (dividend.size() > 1) {
                {
                    division(dividend, divider);
                }
            }
        }
    }

    public int adhesion(int x, int y) {
        int z;
        z = x * 10 + y;
        return z;
    }


    public ArrayList<Integer> rewriting(ArrayList<Integer> rewritable, int k) {
        int temp = adhesion(k, rewritable.get(1));
        rewritable.set(1, temp);
        rewritable.remove(0);
        return rewritable;
    }

    public ArrayList<Integer> rewriting(ArrayList<Integer> rewritable) {
        int temp = adhesion(rewritable.get(1), rewritable.get(2));
        rewritable.set(1, temp);
        rewritable.remove(0);
        return rewritable;
    }
}