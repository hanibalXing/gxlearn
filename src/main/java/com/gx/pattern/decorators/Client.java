package com.gx.pattern.decorators;

/**
 * @author gx
 * @ClassName: Client
 * @Description: java类作用描述
 * @date 2019/2/14 15:36
 * @Version: 1.0
 * @since
 */
public class Client {
    public static void main(String[] args) {
      /*  Coffee coffee=new Milk(new Sugar(new BlaskCoffee()));
        System.out.println(coffee.desc());*/
        String desc = new CoffeeBuilder()
                         .addDecorator(Sugar.class)
                         .addDecorator(Milk.class)
                         .build()
                         .desc();
        System.out.println(desc);
    }
}
