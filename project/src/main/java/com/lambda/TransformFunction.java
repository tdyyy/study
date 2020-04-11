package com.lambda;

import java.util.function.*;

class I {
    String s="I ";
    @Override
    public String toString() { return s; }
}

class O {
    String s = "O ";
    @Override
    public String toString() { return s; }
}

public class TransformFunction {
    static Function<I,O> transform(Function<I,O> in) {
        return in.andThen(o -> {
            o.s+="  K";
            return o;
        });
    }
    public static void main(String[] args) {
        Function<I,O> f2 = transform(transform(transform(transform(transform(transform(transform(transform(i -> {
            System.out.println(i);
            return new O();
        }))))))));
        O o = f2.apply(new I());
        System.out.println(o);
    }
}