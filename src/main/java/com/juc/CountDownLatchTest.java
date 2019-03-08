package com.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            latch.await();
            System.out.println("全部执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}