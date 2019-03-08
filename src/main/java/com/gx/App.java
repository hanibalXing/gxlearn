package com.gx;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*System.out.println( "Hello World!" );
        List<String> list=new ArrayList<>();*/
        Calendar headStartTime = Calendar.getInstance();
        headStartTime.add(Calendar.MINUTE, -5);
        headStartTime.set(Calendar.SECOND, 0);
        Calendar headEndTime = Calendar.getInstance();
        headEndTime.set(Calendar.SECOND, 0);
        System.out.println(headStartTime.getTimeInMillis());
        System.out.println(headEndTime.getTimeInMillis());

        /*Date day=new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");

        System.out.println(df.format(day));*/


    }
}
