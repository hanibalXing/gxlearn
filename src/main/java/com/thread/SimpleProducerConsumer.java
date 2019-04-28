package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author gx
 * @ClassName: SimpleProducerConsumer
 * @Description: java类作用描述
 * @date 2019/4/15 19:32
 * @Version: 1.0
 * @since
 */
public class SimpleProducerConsumer {
    private int i=0;
    private volatile boolean produced=false;
    Object lock=new Object();
    private void produce() throws InterruptedException {
        synchronized (lock){
            while(produced){
                lock.wait();
            }
            i++;
            System.out.println("producer"+i);
            TimeUnit.SECONDS.sleep(2);
            lock.notifyAll();
            produced=true;

        }
    }
    private void consumer() throws InterruptedException {
        synchronized (lock) {
            while (produced) {
                System.out.println("consumer-" + i);
                produced=false;
                lock.notifyAll();
            }
                lock.wait();

        }
    }

    public static void main(String[] args) {
        SimpleProducerConsumer pc=new SimpleProducerConsumer();
        new Thread(()-> {
            while (true) {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()-> {
            while (true) {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()-> {
            while (true) {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()-> {
            while (true) {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
