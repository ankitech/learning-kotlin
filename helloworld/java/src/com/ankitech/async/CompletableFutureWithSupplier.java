package com.ankitech.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureWithSupplier {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            return Thread.currentThread().getName();
        };

        var stringCompletableFuture = CompletableFuture.supplyAsync(supplier);
        stringCompletableFuture.complete("too long");

        var name = stringCompletableFuture.join();

        System.out.println("Result = " + name);
    }
}
