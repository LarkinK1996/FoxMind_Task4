package com.foxminded.int_division;

import java.util.ArrayList;
import java.util.Objects;

public class Memorizer {
    public int value;

    public void add (int x){
        this.value = adhesion(value,x);
    }

    private int adhesion(int x, int y) {
        int z;
        z = x * 10 + y;
        return z;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
