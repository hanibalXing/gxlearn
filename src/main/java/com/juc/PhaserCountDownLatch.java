package com.juc;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserCountDownLatch {
    public static void main(String[] args) {
        final Phaser phaser=new Phaser(3);
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("线程1运行完毕");
                phaser.arriveAndAwaitAdvance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("线程2运行完毕");
                phaser.arriveAndAwaitAdvance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        phaser.arriveAndAwaitAdvance();
        System.out.println("两个线程都运行完毕了");

    }
}
