package com.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gx
 * @ClassName: Test
 * @Description: java类作用描述
 * @date 2019/4/15 17:09
 * @Version: 1.0
 * @since
 */
public class Test {
    static class GxThread implements Runnable{

        AtomicInteger i=new AtomicInteger(100);
        @Override
        public void run() {
           while (i.get()>0){

                System.out.println(i.getAndDecrement());
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
     /*   GxThread gxThread = new GxThread();
        Thread thread1 = new Thread(gxThread);
        Thread thread2= new Thread(gxThread);
        Thread thread3 = new Thread(gxThread);
        thread1.start();
        thread2.start();
        thread3.start();*/


 /*     OverThread overThread = new OverThread();
        Thread thread = new Thread(overThread);
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();*/


    }
}
