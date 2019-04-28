package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author gx
 * @ClassName: TreadException
 * @Description: java类作用描述
 * @date 2019/4/15 22:44
 * @Version: 1.0
 * @since
 */
public class TreadException {
    public static void main(String[] args) {
        int a=10;
        int b=0;

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                int i = a / b;

            } catch (InterruptedException e) {
                System.out.println("error");
            }

        });
        thread.setUncaughtExceptionHandler((t,e)->{
            System.out.println(e);
        });
        thread.start();
    }
}
