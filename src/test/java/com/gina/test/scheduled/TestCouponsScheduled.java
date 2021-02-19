package com.gina.test.scheduled;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestCouponsScheduled {


        /**
         \* 订单完成 发放优惠券通知
         */
        //public static final String COUPON_SEND_NOTICE = "coupon_send_notice";

        static Set<String> coupon_send_notice=new HashSet<String>();
        static Set<String> coupon_send_notice_1_wang=new HashSet<String>();
        static  Set<String> coupon_send_notice_2_li=new HashSet<String>();
        static  Set<String> quaninValideSet=new HashSet<String>();
        static  Set<String> allCoupons=new HashSet<String>();
        static  Set<String> invalideCoupon=new HashSet<String>();

        static Map<String,Long> map=new HashMap<String,Long>();
        static Map<String,Set<String>> mapPerson=new HashMap<String,Set<String>>();
        static Map<String,Set<String>> mapAllCoupons=new HashMap<String,Set<String>>();

        @BeforeClass
        public static void init(){
        coupon_send_notice.add("coupon_send_notice_1_wang");
        coupon_send_notice.add("coupon_send_notice_2_li");

        coupon_send_notice_1_wang.add("coupon_send_notice_1_CouponId1");
        coupon_send_notice_1_wang.add("coupon_send_notice_1_CouponId2");

        coupon_send_notice_2_li.add("coupon_send_notice_2_CouponId3");
        coupon_send_notice_2_li.add("coupon_send_notice_2_CouponId4");
        coupon_send_notice_2_li.add("coupon_send_notice_2_CouponId5");

        map.put("coupon_send_notice_1_CouponId1",1599390264000L);
        map.put("coupon_send_notice_1_CouponId2",1599396924000L);
        map.put("coupon_send_notice_2_CouponId3",1599396924000L);
        map.put("coupon_send_notice_2_CouponId4",1599396924000L);
        map.put("coupon_send_notice_2_CouponId5",1599390264000L);

        mapPerson.put("coupon_send_notice_1_wang",coupon_send_notice_1_wang);
        mapPerson.put("coupon_send_notice_2_li",coupon_send_notice_2_li);

        allCoupons.add("coupon_send_notice_1_CouponId1");
        allCoupons.add("coupon_send_notice_1_CouponId2");
        allCoupons.add("coupon_send_notice_2_CouponId3");
        allCoupons.add("coupon_send_notice_2_CouponId4");
        allCoupons.add("coupon_send_notice_2_CouponId5");

        //mapAllCoupons.put("coupon_send_notice_coupon",allCoupons);
    }

        @Test
        public void test(){
        System.out.println(coupon_send_notice.toString());
        System.out.println("-----------");
        System.out.println(coupon_send_notice_1_wang.toString());
        System.out.println("-----------");
        System.out.println(coupon_send_notice_2_li.toString());
    }


/*0 0/30 9-17 * * ?*/

        @Scheduled(cron="0 */1 * * * ? ")  //每分钟执行一次
        public void testDealQuan(){
        allCoupons.forEach(item->{
            if(System.currentTimeMillis()> map.get( item)) {
                quaninValideSet.add(item);
            }
        });
        if(quaninValideSet.isEmpty()){
            System.out.println("没有失效的券，不予处理");
            return;
        }

        System.out.println("所有过期的券："+quaninValideSet);

        coupon_send_notice.forEach(item->{
            //根据人获取券set,得到size   set为-- COUPON_SEND_NOTICE + "_" + tenantId + "_" + pin
            int count=mapPerson.get(item).size();

            //遍历这个人的所有券
            mapPerson.get(item).removeAll(quaninValideSet);

        });
        //最后处理
        System.out.println("------过期的--------");
        System.out.println(quaninValideSet.toString());
        System.out.println("------wang--------");
        //coupon_send_notice_1_wang.removeAll(quaninValideSet);
        System.out.println(coupon_send_notice_1_wang.toString());

        System.out.println("------li--------");
        //coupon_send_notice_2_li.removeAll(quaninValideSet);
        System.out.println(coupon_send_notice_2_li.toString());
    }

}
