package com.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest
{
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程组执行结束");
            }
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new readNum(i,cyclicBarrier)).start();
        }

    }
    static class readNum  implements Runnable{
        private int id;
        private CyclicBarrier cyc;
        public readNum(int id,CyclicBarrier cyc){
            this.id = id;
            this.cyc = cyc;
        }
        @Override
        public void run() {


                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(id+"执行完毕");
                    cyc.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
    }
}

