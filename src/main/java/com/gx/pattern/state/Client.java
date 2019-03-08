package com.gx.pattern.state;

/**
 * @author gx
 * @ClassName: Client
 * @Description: java类作用描述
 * @date 2019/2/3 15:51
 * @Version: 1.0
 * @since
 */
public class Client {
    public static void main(String[] args) {
        Box box=new Box(new EmptyState(),30);
        for (int i=0;i<40;i++){
            System.out.println(box.put());
        }

    }
}
