package com.tools;

import java.text.NumberFormat;

/**
 * @author gx
 * @ClassName: Utils
 * @Description: java类作用描述
 * @date 2018/10/2 14:26
 * @Version: 1.0
 * @since
 */
public class Utils {
    public static String getPer(int a,int b){

        if (b==0) {
            return 0+"%";
        }

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) a / (float) b * 100);

        return result+"%";
    }
}
