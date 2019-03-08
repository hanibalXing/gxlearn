package com.gx.pattern.decorators;

/**
 * @author gx
 * @ClassName: Milk
 * @Description: java类作用描述
 * @date 2019/2/14 15:34
 * @Version: 1.0
 * @since
 */
public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String desc() {
        return super.desc()+"加糖";
    }
}
