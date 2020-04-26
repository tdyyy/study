package com.thread;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
public class QuittingTasks {
    public static final int COUNT = 150;
    public static void main(String[] args) {
        ExecutorService es =
                Executors.newCachedThreadPool();
        List<QuittableTask> tasks =
                IntStream.range(1, COUNT)
                        .mapToObj(QuittableTask::new)
                        .peek(qt -> es.execute(qt))
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        es.shutdown();


//        List<QuittableTask> tasks =
//                IntStream.range(1, QuittingTasks.COUNT)
//                        .mapToObj(QuittableTask::new)
//                        .collect(Collectors.toList());
//        List<CompletableFuture<Void>> cfutures =
//                tasks.stream()
//                        .map(CompletableFuture::runAsync)
//                        .collect(Collectors.toList());
//        new Nap(1);
//        tasks.forEach(QuittableTask::quit);
//        cfutures.forEach(CompletableFuture::join);
    }
}