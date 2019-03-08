package com.juc;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException {
        IntStream.rangeClosed(0,10).boxed().forEach(i->CompletableFuture.supplyAsync(CompletableFutureTest::getDate)
                .thenAccept(CompletableFutureTest::dealDate).whenComplete((v,t)-> System.out.println(i))

        );
        Thread.currentThread().join();
    }


    private static String getDate()
    {
        int random= new Random().nextInt(10);
        sleep(random);
        System.out.println( Thread.currentThread().getName()+" ---getDate after"+random+"秒");
        return String.valueOf(random);
    }

    private static void dealDate(String date)
    {
        int random= new Random().nextInt(10);
        sleep(random);
        System.out.println( Thread.currentThread().getName()+" ---dealDate ("+date+") after"+random+"秒");
    }


    private static void sleep(long time)
    {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
