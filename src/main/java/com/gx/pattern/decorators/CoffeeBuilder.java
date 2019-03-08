package com.gx.pattern.decorators;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gx
 * @ClassName: CoffeeBuilder
 * @Description: java类作用描述
 * @date 2019/2/14 15:38
 * @Version: 1.0
 * @since
 */
public class CoffeeBuilder {

    //被装饰类
    private Class<? extends Coffee> implementation;
    //所有的装饰器存放在一个数组中
    private  List<Class<? extends Coffee>> decorators;

    public CoffeeBuilder() {
        decorators=new ArrayList<>();
    }

    public CoffeeBuilder implementation(Class<? extends Coffee> implementation) {
        this.implementation = implementation;
        return this;
    }

    public CoffeeBuilder addDecorator(Class<? extends Coffee> decorator) {
        if (decorator != null) {
            this.decorators.add(decorator);
        }
        return this;
    }

    /**
     * 设置默认的咖啡品种和装饰器
     */
    private void setDefaultImplementations() {
        if (implementation == null) {
            implementation = BlaskCoffee.class;
            if (decorators.isEmpty()) {
                decorators.add(Sugar.class);
            }
        }
    }


    public Coffee build(){
        setDefaultImplementations();
        try {
            Coffee coffee=implementation.newInstance();
            for (Class<? extends Coffee> decorator : decorators) {
                coffee = newCoffeeDecoratorInstance(decorator, coffee);
            }
            return coffee;
        } catch (InstantiationException  | IllegalAccessException e ) {
            throw new RuntimeException("构建失败");
        }
    }

    private Coffee newCoffeeDecoratorInstance(Class<? extends Coffee> coffeeClass, Coffee base) {
        try {
        Constructor<? extends Coffee> coffeeConstructor = coffeeClass.getConstructor(Coffee.class);
        return coffeeConstructor.newInstance(base);
        } catch (Exception e) {
           throw new RuntimeException("装饰失败");
        }
    }




}
