package com.ankitech.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstCompletableFuture {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> System.out.println("I am running async on thread : " + Thread.currentThread().getName());


        CompletableFuture.runAsync(task);
        CompletableFuture.runAsync(task, executor);

        Thread.sleep(1000);
        executor.shutdown();
    }
}
