package com.juc;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReedWriteLockTest {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock lock=new ReentrantReadWriteLock(false);

        final AtomicInteger i=new AtomicInteger(1);
        //写线程
        new Thread(()->{
          try {
              lock.writeLock().lock();
              System.out.println("更新数据--"+i.incrementAndGet());
            }
            finally {
              lock.writeLock().unlock();
          }
        }).start();

        new Thread(()->{
            try {
                lock.writeLock().lock();
                System.out.println("更新数据--"+i.incrementAndGet());
            }
            finally {
                lock.writeLock().unlock();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            try {
                lock.readLock().lock();
                System.out.println("读取数据--"+i.get());
            }
            finally {
                lock.readLock().unlock();
            }
        }).start();

        new Thread(()->{
            try {
                lock.readLock().lock();
                System.out.println("读取数据---"+i.get());
            }
            finally {
                lock.readLock().unlock();
            }
        }).start();

    }


}
