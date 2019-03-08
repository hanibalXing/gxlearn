package com.gx.pattern.state;

/**
 * @author gx
 * @ClassName: Box
 * @Description: java类作用描述
 * @date 2019/2/3 15:43
 * @Version: 1.0
 * @since
 */
public class Box {
    private int max;
    private int initCapacity=0;
    private BoxState state;
    public Box(BoxState state,int max ){
        this.max=max;
        this.state=state;
    }

    public BoxState getState() {
        return state;
    }

    public String put(){
        initCapacity++;
        if(initCapacity>max) {
            state=new FullState();
        }
        int left=max - initCapacity;
        return state.state()+"left cpacity ="+ (left >= 0 ? left : 0);
    }
}
