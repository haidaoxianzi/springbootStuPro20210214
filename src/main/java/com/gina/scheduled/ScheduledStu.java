package com.gina.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/9/10 - 09 - 10 -16:02
 * Email: wuqiong76@jd.com
 */
@Component
@Slf4j
public class ScheduledStu {
    /**
    * @Description:  探索定时调度  方式1
    * @Param:
    * @return:
    * @Author: wuqiong
    * @Date:
    */
    Long a=new Date().getTime();
   // @Scheduled(cron = "0/10 * * * * *")
    public void a(){
        log.info("111111hello ,world ~1,date={}",String.valueOf(a));
        String nn=null;
        System.out.println(nn.toString());
    }

 // @Scheduled(fixedDelay = 1000*10)
    public void a2(){
        log.info("222222222hello ,world ~2,date={}",String.valueOf(a));
      String nn=null;
      System.out.println(nn.toString());
    }

    @Scheduled(fixedRate = 1000*10)
    public void a3(){
        log.info("33333333hello ,world ~3,date={}",String.valueOf(a));
        String nn=null;
        System.out.println(nn.toString());
    }
}
