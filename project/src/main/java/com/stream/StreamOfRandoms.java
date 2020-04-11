package com.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfRandoms {

    public static void main(String[] args) {
        Stream.of(1,2,3,4)
                .flatMapToInt(i -> IntStream.iterate(1,k->k+1).limit(i))
                .forEach(System.out::print);
        System.out.println();
        Stream.of(1,2,3,4)
                .flatMapToInt(i -> IntStream.concat(IntStream.iterate(1,k->k+2).limit(i),IntStream.of(-1)))
                .forEach(System.out::print);

    }
}
