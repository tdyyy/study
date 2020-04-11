package com.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class test {
    public static class MyThread implements Runnable{
        private Map map;
        private String name;
        private Integer index;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map getMap() {
            return map;
        }

        public void setMap(Map map) {
            this.map = map;
        }

        public MyThread(Map map, String name,Integer index) {
            this.map = map;
            this.name = name;
            this.index = index;
        }

        @Override
        public void run() {
            IntStream.iterate(index, i -> i+2)
                    .limit(50)
                    .boxed()
                    .forEach(i->{
                        map.put(i,name+"  "+i);
                    });
        }
    }
    private static Map map;
    private static String name;
    private static Integer index;
    public static void main(String[] args) throws Exception{
        Map<Integer,Object> map = new HashMap();

        MyThread t1 = new MyThread(map,"thread1",1);
        MyThread t2 = new MyThread(map,"thread2",2);
        Thread t = new Thread(test::fun1);
        t1.run();
        t2.run();
        System.out.println();
    }

    public static void fun1(){
        IntStream.iterate(index, i -> i+2)
                .limit(50)
                .boxed()
                .forEach(i->{
                    map.put(i,name+"  "+i);
                });
    }

}
