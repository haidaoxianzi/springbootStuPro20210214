package com.gina.testconvert;

import com.alibaba.fastjson.JSON;
import com.gina.convert.AppleConvert;
import com.gina.convert.MoreFieldConvert;
import com.gina.pojo.WareRanking;
import com.gina.pojo.otherpojo.Apple;
import com.gina.pojo.otherpojo.Orange;
import com.xstore.game.center.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/10/8 - 10 - 08 -13:50
 * Email: wuqiong76@jd.com
 */
@Slf4j
public class TestConvert {
    List<Apple> list = new ArrayList<>();

    @Before
    public void iniListData2() {
        list.clear();
        Date curDate = new Date();
        Apple a = new Apple(1L, "red1", BigDecimal.valueOf(1.1d), DateUtils.addDays(curDate, 1));
        Apple b = new Apple(2L, "red2", BigDecimal.valueOf(1.2d), curDate);
        Apple c = new Apple(3L, "red3", BigDecimal.valueOf(1.3d), DateUtils.addDays(curDate, 2));
        Apple d = new Apple(4L, "red4", BigDecimal.valueOf(1.4d), DateUtils.addDays(curDate, 3));
        Apple e = new Apple(5L, "red5", BigDecimal.valueOf(1.4d), DateUtils.addDays(curDate, 4));

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        List<WareRanking> wareRankLists=null;
        for(Apple aa :list ){
            wareRankLists=new ArrayList<>();
            for(int i=1;i<=3;i++){
                wareRankLists.add(new WareRanking("a",i));
            }
            aa.setWareRankLists(wareRankLists);
        }
    }
    /**
     * 适用场景：
     * list  泛型为对象，要转换对象的多个属性
     * */
    @Test
    public void testConvertList(){

        List<Orange> orangeList=AppleConvert.convertAppleList.apply(list);
        log.info("orangeList={}", JSON.toJSONString(orangeList));
    }
    /**
     * 适用场景：
     * 要转换一个对象的多个属性
     * */
    @Test
    public void testConvertObject(){
        Apple a=   new Apple("red", BigDecimal.valueOf(1.2));
        List<WareRanking>   wareRankLists=new ArrayList<>();
        for(int i=1;i<=3;i++){
            wareRankLists.add(new WareRanking("a"+i,i));
        }
        a.setWareRankLists(wareRankLists);
        Orange orange=AppleConvert.convertApple.apply(a);

        log.info("orange={}", JSON.toJSONString(orange));
    }



}
