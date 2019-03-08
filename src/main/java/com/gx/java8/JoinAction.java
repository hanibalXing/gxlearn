package com.gx.java8;

import java.util.Arrays;
import java.util.Random;

public class JoinAction {
    public static void main(String[] args) throws Exception {
       /* Thread a1=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        });
        a1.start();
        Thread a2=new Thread(()->{
            System.out.println("2");
        });
        a2.start();
        Thread a3=new Thread(()->{
            System.out.println("3");
        });
        a3.start();
        Thread a4=new Thread(()->{
            System.out.println("4");
        });
        a4.start();
        a1.join();
        a2.join();
        a3.join();
        a4.join();*/
     /*   Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().forEach(i->new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("args = [" + i + "]");
        }).start());*/
        for (int i = 0; i <10 ; i++) {
            Thread a =new Thread(()->{
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("args = [" + Thread.currentThread().getName()  + "]");
            });
            a.start();

        }
       // Thread.currentThread().join();
    }
}
