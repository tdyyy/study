package com.thread;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Rand {
    public static Supplier<String> String (int i){
        return ()-> new Random()
                .ints(97,122)
                .limit(i)
                .mapToObj(z -> String.valueOf((char)z))
                .reduce((a, b)->a+b).get();
    }


    public static void main(String[] args) {
        new Random()
                .ints(97,122)
                .limit(5)
                .peek(System.out::println).reduce((a, b)->a+b);
    }
}
