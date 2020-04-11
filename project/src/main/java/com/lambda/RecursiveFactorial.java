package com.lambda;

public class RecursiveFactorial {
    private static IntCall intCall;
    public static void main(String[] args) {
        int i = 10;
        System.out.println(call(i));
        intCall = j->{
            if(j==1||j==2)return 1;
            return intCall.call(j-1)+intCall.call(j-2);
        };
        System.out.println(intCall.call(10));
    }
    public static Integer call(int i){
        if(i==1){
            return 1;
        }else {
            return i * call(i - 1);
        }
    }

}
interface IntCall{
    Integer call(Integer integer);
}
