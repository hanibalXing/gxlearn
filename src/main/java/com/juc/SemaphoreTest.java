package com.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore s=new Semaphore(1);
        new Thread(()->{
            try {
                s.acquire();
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                s.release();
            }
        }).start();
    }
}
