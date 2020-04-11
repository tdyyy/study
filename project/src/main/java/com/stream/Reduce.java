package com.stream;

import java.util.*;
import java.util.stream.*;
class Frobnitz {
    int size;
    Frobnitz(int sz) { size = sz; }
    @Override
    public String toString() {
        return "Frobnitz(" + size + ")";
    }
    // Generator:
    static Random rand = new Random(47);
    static final int BOUND = 100;
    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}
public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
                .reduce((fr0, fr1) -> fr0.size < 10 ? fr0 : fr1)
                .ifPresent(System.out::println);

        Stream.of("a1","aaa","bbb","bs1","acas","c1","ee","s")
                .reduce((s1,s2) -> s1.contains("s")?s1:s2)
                .ifPresent(System.out::println);
    }
}