package com.juc;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ThreadPoolTest
{
    public static void main(String[] args) throws InterruptedException {
        Optional.ofNullable(Runtime.getRuntime().availableProcessors()).ifPresent(System.out::println);
        useWorkStealingPool();

    }

    private static  void useCachedThredPool()
    {
        ExecutorService executorService= Executors.newCachedThreadPool();

    }

    private static void useFixedThreadPool()
    {
        ExecutorService executorService= Executors.newFixedThreadPool(10);

    }

    private  static void useSingleThreadPool()
    {
        ExecutorService executorService=Executors.newSingleThreadExecutor();

    }

    private  static void useWorkStealingPool() throws InterruptedException {
        ExecutorService executorService=Executors.newWorkStealingPool();

        List<Callable<String>> collect = IntStream.rangeClosed(0, 10).boxed().map(i ->
                (Callable<String>) () ->
                {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                    return "task" + i;

                }).collect(toList());
        List<Future<String>> futures = executorService.invokeAll(collect);
        futures.stream().map(future->{
            try {
                return future.get();
            } catch (Exception e) {
               throw new RuntimeException();
            }
        }).forEach(System.out::println);
    }



}
