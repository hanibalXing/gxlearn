package com.gx.pattern.decorators;

/**
 * @author gx
 * @ClassName: CoffeeDecorator
 * @Description: java类作用描述
 * @date 2019/2/14 15:33
 * @Version: 1.0
 * @since
 */
public  abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee=coffee;
    }

    @Override
    public String desc() {
        return coffee.desc();
    }
}
