package com.gx.java8;

import com.gx.App;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Snippet
{
    public static void main(String[] args)
    {
      /*  List<Integer> filterLists = new ArrayList<>();
        for(int i=0;i<10000000;i++)
        {
            filterLists.add(i);
        }

        Date a = new Date();
        for(int j=0;j<10000000;j++)
        {
            System.out.println(filterLists.get(j));
        }
        Date b = new Date();

        Date c = new Date();
        filterLists.stream().forEach(s -> System.out.println(s));
        Date d = new Date();*/

        List<Apple> appleList=new ArrayList<>();
       for(int i=0;i<10000000;i++)
       {
           appleList.add(new Apple("green",120));
       }
        Date a = new Date();
        //Long reduce = appleList.stream().parallel().map(ap -> ap.getWeight()).reduce(0L, (n1, n2) -> n1 + n2);
        Long reduce = appleList.stream().parallel().collect(Collectors.summingLong(Apple::getWeight));
        Date b = new Date();
        System.out.println(reduce);
        Date c = new Date();
        long sum=0;
        for(Apple suba:appleList)
        {
            sum+=suba.getWeight();
        }
        Date d = new Date();
        System.out.println(sum);
        long interval = b.getTime()-a.getTime();
        long interval2 = d.getTime()-c.getTime();
        System.out.println("两个时间相差1:"+interval);//6602
        System.out.println("两个时间相差2:"+interval2);//6824
        //p1表示for性能,p2表示流处理性能
       /* long p1 = 0, p2 = 0;
        int n = 500000;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int j = 0; j < 100; j ++) {
            for(int i = 0; i < n; i ++) {
                arr.add(i);
            }
            Integer sum = 0;
            long t1 = System.nanoTime();
            for(Integer v : arr) {
                sum = sum + v;
            }
            long t2 = System.nanoTime();
            arr.parallelStream().reduce(0, (a, b) -> a + b);
            //arr.stream().parallel().reduce(0, (a, b) -> a + b);
            long t3 = System.nanoTime();
            p1 += (t2 - t1);
            p2 += (t3 - t2);
            arr.clear();
        }
        System.out.println(p1 / 100 / 1000);
        System.out.println(p2 / 100 / 1000);*/


    }
}