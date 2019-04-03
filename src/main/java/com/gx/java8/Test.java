package com.gx.java8;

import com.tools.GroupByUtil;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author gx
 * @ClassName: Test
 * @Description: java类作用描述
 * @date 2019/2/11 7:45
 * @Version: 1.0
 * @since
 */
public class Test {
    public static void main(String[] args) throws Exception {
      /*  Function<String,String> f= (s)-> "a"+s;
        BiFunction<String,String,String> bf=(s,t)->{
            return s+t;
        };
        Predicate<String> p=(s)-> s.equals("1");
        Consumer<String> c=(s)->System.out.println(s);
        GreetingService<String> service=(s)->{
            System.out.println(s.length());
            return s;
        };

        service.sayMessage("123");
        System.out.println(f.apply("1"));
        System.out.println(bf.apply("1","2"));
        System.out.println(p.test("1"));
        c.accept("456");*/

        Arrays.asList("123","3213","12321").stream().filter(s -> s.length()>4).forEach(System.out::println);
        GroupByUtil.groupBy("weight",Arrays.asList(new Apple("red",123)
                ,new Apple("red",123)),"color").forEach((k,v)->{
            System.out.println(k+"========"+v);
        });
    }

    @FunctionalInterface
    interface GreetingService<T>
    {
        T sayMessage(String message);
    }
}
