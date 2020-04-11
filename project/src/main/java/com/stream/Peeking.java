package com.stream;

import java.util.stream.Stream;

class Peeking {
    public static void main(String[] args) throws Exception {
        Stream.of("I am so smart".split(" "))
                .map(w -> w + " ")
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}