package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author gx
 * @ClassName: OverThread
 * @Description: java类作用描述
 * @date 2019/4/15 19:04
 * @Version: 1.0
 * @since
 */
public class OverThread implements Runnable {
    boolean a=true;
    @Override
    public void run() {
        while (a){
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                a=false;
            }
            System.out.println("run");
        }
    }

}
