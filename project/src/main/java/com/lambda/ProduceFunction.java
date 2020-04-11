package com.lambda;

import java.util.function.*;

interface FuncSS extends DoubleToIntFunction {} // [1]

public class ProduceFunction {
    static FuncSS produce() {
        return s -> (int)s; // [2]
    }
    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.applyAsInt(25.15156123D));
    }
}
