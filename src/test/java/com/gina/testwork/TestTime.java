package com.gina.testwork;

import com.xstore.game.center.utils.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {
    @Test
    public void test(){
        //String a="2021-01-19 11:59:59";

        Long a=DateUtils.addHours(new Date(),-3).getTime() +640498408L;
        Date b=new Date(a);
       String c= DateUtils.formatDate(b,"yyyy-MM-dd HH:mm:ss");
        System.out.println(c);
        System.out.println(DateUtils.compareDate(new Date(),b));
    }

}
