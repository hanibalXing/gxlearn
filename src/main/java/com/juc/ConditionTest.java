package com.juc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    private List<Integer> data = new LinkedList<>();
    private static final int MAX_DATA_LEN = 10;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();// 非空条件
    private Condition notFull = lock.newCondition();// 非满条件


    class Producer implements Runnable {

        private int pid = 0;

        public Producer(int pid){
            this.pid = pid;
        }

        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {


                    lock.lock();
                    //生产者生产的数据已满，等待消费者消费
                    while (data.size() >= MAX_DATA_LEN) {
                        System.out.println("Producer" + pid + " waiting ! size : " + data.size());
                        notFull.await(); // 等待notFull.signal唤醒
                    }
                    //未满，继续生产
                    try{
                        data.add(pid);
                        notEmpty.signal(); // 通知消费者可以消费了
                        System.out.println("Producer" + pid + " add " + pid + " size: " + data.size());

                    }finally {
                        lock.unlock();
                    }

                    Thread.sleep(500);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }


    class Consumer implements Runnable{
        private int cid = 0;

        public Consumer(int cid){
            this.cid = cid;
        }

        public void run(){
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    lock.lock();
                    //消费完了等待生产者生产
                    while (data.isEmpty()) {
                        System.out.println("Consumer" + cid + " waiting, data size : " + data.size());
                        notEmpty.await();
                    }
                   //有数据可以消费
                    try{
                        int pid = data.remove(0);
                        notFull.signal();//告诉生产者可以继续生产
                        System.out.println("Consumer" + cid + " consuming data " + pid +" data size : " + data.size());

                    }finally {
                        lock.unlock();
                    }

                    Thread.sleep(500);
                }
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }


    public void start(){



        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 5; ++ i){
            executor.submit(new Producer(i));
            executor.submit(new Consumer(i));
        }

        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }


    public static void main(String []args){

        new ConditionTest().start();

    }

}
