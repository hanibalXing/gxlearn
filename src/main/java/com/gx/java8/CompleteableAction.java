package com.gx.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteableAction {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(()-> {

            try {
                return m1();
            } catch (InterruptedException e) {
               return 2;
            }

        }).handle((v,e)->Integer.sum(v,10)).thenAccept(System.out::println).join();

        CompletableFuture.supplyAsync(()-> {

            try {
                return m1();
            } catch (InterruptedException e) {
                return 2;
            }

        }).thenCombine(CompletableFuture.supplyAsync(()-> {
            try {
                return m1();
            } catch (InterruptedException e) {
                return 1;
            }
        }),(r1,r2)->r1+r2).thenAccept(System.out::println);
       /* String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result);*/


        //TimeUnit.SECONDS.sleep(5);
    }

    private static int m1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName());
        return 1;
    }

}
