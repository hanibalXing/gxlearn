package com.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreTest2
{
    public static void main(String[] args) throws InterruptedException {
         //超过50000，交易失败
         AtomicInteger cash=new AtomicInteger(0);
        //创建线程池
        int count = 100;
        ExecutorService threadPool = Executors.newFixedThreadPool(count);

        //控制信号量，即线程并发数量为2
        Semaphore bankers = new Semaphore(2);
        //当前客户编号
        int consumer = 0;
        System.out.println("空闲业务员有："+bankers.availablePermits()+" 位");
        //客户数量
        for(int i=1;i<=count;i++){
            consumer = i;
            Bank bank = new Bank(bankers,consumer,cash);
            threadPool.execute(bank);
        }

        threadPool.shutdown();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("空闲业务员有："+bankers.availablePermits()+" 位");
    }

}

class Bank implements Runnable{

    //银行业务员们
    private Semaphore bankers;
    //当前客户
    private int consumer;
    private AtomicInteger cash;
    public Bank(Semaphore bankers, int consumer,AtomicInteger cash){
        this.bankers = bankers;
        this.consumer = consumer;
        this.cash=cash;
    }

    @Override
    public void run() {
        //客户拿号阶段，并不控制并发数量
        System.out.println("======客户进入银行先拿号，号码："+consumer+"，请等待叫号=========");
        try {
            //客户办理业务阶段，限制最多只能有2位客户同时办理业务
            //以上两条注释，可以发现更细粒度的控制线程并发个数

            //业务员开始服务，被占用
            bankers.acquire();

            System.out.println("客户："+consumer+" 开始办理业务，start 取钱 1000");
            System.out.println("还剩业务员："+bankers.availablePermits()+" 位");
            Thread.sleep(100);
            System.out.println("客户："+consumer+" 办理业务完毕，end");
            int c=cash.addAndGet(1000);
            System.out.println("已取"+c);
            if(c>50000)
            {
                System.out.println("交易失败");
            }

            //业务办理结束之后，业务员释放，准备为下一个客户服务

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            bankers.release();
        }
    }
}
