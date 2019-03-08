package com.juc;

import java.util.concurrent.Phaser;

public class PhaserTest1 {
    public static void main(String[] args) {
        Phaser phaser = new MyPhaser();

        for (int i = 0; i < 5; i++) {
            phaser.register();
            Task_01 task_01 = new Task_01(phaser);
            Thread thread = new Thread(task_01, "PhaseTest_" + i);
            thread.start();
        }

    }

    static class Task_01 implements Runnable {
        private final Phaser phaser;

        public Task_01(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行任务完成，等待其他任务执行......");
            //等待其他任务执行完成
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "继续执行任务...");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "任务完成...");
        }
    }
    public static class MyPhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
          //  System.out.println(phase+"---"+registeredParties);
            return super.onAdvance(phase, registeredParties);
        }
    }
    }
