package com.gx.future;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService testPool= Executors.newCachedThreadPool();
        Future<?> f1 = testPool.submit(() -> {
                    try {
                        Thread.sleep(1000 * 14);
                        System.out.println("包子准备完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        Future<?> f2 = testPool.submit(() -> {
                    try {
                        Thread.sleep(1000 * 18);
                        System.out.println("包子准备完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        f1.cancel(true);
        System.out.println(f1.isDone());


       /* long start = System.currentTimeMillis();

        // 等凉菜
        Callable ca1 = new Callable(){

            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Callable ca2 = new Callable(){

            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();
        System.out.println(ft1.isDone());
        System.out.println(ft1.get());
        ft1.cancel(true);
        System.out.println(ft2.get());
        System.out.println(ft1.isDone());
        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));*/

    }
}
