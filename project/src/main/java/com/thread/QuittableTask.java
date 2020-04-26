package com.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class QuittableTask implements Runnable {
    private AtomicInteger id;
    public QuittableTask(int id) {
        this.id = new AtomicInteger(id);
    }
    private AtomicBoolean running =
            new AtomicBoolean(true);
    public void quit() {
        running.set(false);
    }
    @Override
    public void run() {
        while(running.get())         // [1]
            new Nap(0.01);
         id.getAndIncrement();
        System.out.println(id + " "+Thread.currentThread().getName());  // [2]
    }

}