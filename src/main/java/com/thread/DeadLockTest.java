package com.thread;

public class DeadLockTest
{
    public static void main(String[] args) {
        Object lock1=new Object();
        Object lock2=new Object();
        Thread t1=new Thread(()->{
            synchronized (lock1)
            {
                System.out.println("t1 start");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2)
                {
                    System.out.println("get lock2");
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized (lock2)
            {
                System.out.println("t2 start");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1)
                {
                    System.out.println("get lock1");
                }
            }
        });
        t1.start();
        t2.start();

    }
}
