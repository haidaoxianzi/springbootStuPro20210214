package com.gina.testwork;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.gina.pojo.ClubCategoryInfo;
import com.gina.pojo.WareRanking;
import com.gina.pojo.otherpojo.Apple;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/11/18 - 11 - 18 -19:46
 * Email: wuqiong76@jd.com
 */
public class Teststr {

    @Test
    public void test4(){
        String b="有机蔬菜大赏";
            String a=String.format("入选[%s]",b);
            System.out.println(a);
    }

    @Test
    public void test(){
        double radio1=0;
        String str="https://m.360buyimg.com/pop/jfs/t1/142686/32/13339/195508/5fa3c5a2E0d6c3f32/29d122e9b3d974c8.jpg!cc_3x5";
        String[] imageScaleArr =str.split("!cc_");
        String coverImg = "";
        // 处理coverImg,images ,以！cc_为分隔符，得到比例 4x3 ,  eg:  coverImg=https://m.360buyimg.com/pop/jfs/t1/142686/32/13339/195508/5fa3c5a2E0d6c3f32/29d122e9b3d974c8.jpg!cc_3x5
        if(null != imageScaleArr && imageScaleArr.length > 1) {
            coverImg = imageScaleArr[0];
            String scaleStr = imageScaleArr[1];
            String[] scaleArr = scaleStr.split("x");
            if (scaleArr.length > 1 && 0 != Double.valueOf(scaleArr[1]).intValue()) {
                BigDecimal radio = new BigDecimal(scaleArr[0]).divide(new BigDecimal(scaleArr[1])).setScale(2, BigDecimal.ROUND_DOWN);
                if(radio.compareTo(BigDecimal.ZERO) > 0) {
                      radio1 = radio.doubleValue();
                }
            }
        }
        System.out.println(radio1);
    }
    @Test
    public void test2(){

        Set<Long> skuIdList = Stream.of(1L,20L,30L,4L,8L,5L,6L,7L).collect(Collectors.toSet());

        Set<Long> newSet=new HashSet<>();
        skuIdList.stream().peek(o->{
            if(newSet.size()<4){
                newSet.add(o);
            }
        }).collect(Collectors.toList());

        System.out.println(newSet.toString());
        System.out.println(skuIdList);

        skuIdList.clear();
        skuIdList.addAll(newSet);
        System.out.println(skuIdList);

      /*Set<Long> h = new HashSet<Long>() {{
            add(1L);
            add(2L);
        }};*/

    }
    @Test
    public void test3(){
        try {
            String a=null;
            System.out.println("".equals(a));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(2);
        }
    }

    @Test
    public void test1(){
        ClubCategoryInfo clubCategoryInfo=new ClubCategoryInfo();
        clubCategoryInfo.setContentSubType(3);
        clubCategoryInfo.setSkuCount(3);
        System.out.println(clubCategoryInfo.getContentSubType().equals(clubCategoryInfo.getSkuCount()));

    }
    @Test
    public void test22(){
       // Long a=1593532800000L;
        Date date=new Date();
        /*System.out.println(date.getTime()>a);
        System.out.println(longToDate(a));*/
        String aa=getStringDateByFmt2(date);
        System.out.println(aa);

    }
    @Test
    public void test21(){
        Long a=1630252800000L;
      //  System.out.println(date.getTime()>a);
        System.out.println(longToDate(a));

    }
    @Test
    public void test23(){
       BigDecimal a=new BigDecimal("0.01");
        System.out.println(a.toPlainString());

    }
    /**
     * 获取字符串时间
     *
     * @return 返回短时间字符串格式yyyyMMdd
     */
    public static String getStringDateByFmt2(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM.dd");
        return formatter.format(date);
    }
    /**
     * 获取字符串时间
     *
     * @return 返回短时间字符串格式yyyyMMdd
     */
    public static String getStringDateByFmt(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd日HH:mm");
        return formatter.format(date);
    }
    /**
     * @Description: long类型转换成日期
     *
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }

    public static String longToDate1(long lo){
        Date date = new Date(lo);
        //  SimpleDateFormat sd = new SimpleDateFormat("MM/dd日kk点");
       SimpleDateFormat sd =new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
       // a.getTime() +1000
        return sd.format(date);
    }

    @Test
    public void test111() {
        Date a = new Date("2020/12/23 23:59:59");
       // System.out.println(longToDate1(a.getTime() +1000));
        //System.out.println(getTimesnight(a));
        String x=longToDate1(a.getTime()+1000);

        System.out.println( getTimesnight(a)+","+x);

    }
    public static String getTimesnight(Date date) {

        //  SimpleDateFormat sd = new SimpleDateFormat("MM/dd日kk点");
       /* SimpleDateFormat sd =new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String str=sd.format(date);*/

        Calendar c = Calendar.getInstance();
        c.setTime(new Date(date.getTime()+1000));
        //c.add(Calendar.DAY_OF_MONTH,-1);
        //int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH)-1;
        int hour = c.get(Calendar.HOUR_OF_DAY);
       // int minute = c.get(Calendar.MINUTE);
       // int second = c.get(Calendar.SECOND);
        String aa=month+"/"+day+"日"+hour+"点";
        return aa;
    }
   /* List<Student> students = new ArrayList<>();

        students.add(new Student(1,"张三",90));
        students.add(new Student(2,"李四",60));
        students.add(new Student(3,"王五",30));
        students.add(new Student(4,"赵六",85));

    int studentId = 3;
    Student student = students.stream().filter(o -> o.getId() == studentId).findAny().orElse(null);*/

    @Test
    public void test121() {
       Map map=new HashMap();
       map.put(null,1);
       map.put(null,2);
        System.out.println(map);

    }
    @Test
    public void test1212() {
        Map<Long, Boolean> mapAllowRetry =new HashMap<>();
        mapAllowRetry.put(1L,null);
        System.out.println(mapAllowRetry);

    }
    /**空列表截取0个元素，不会报错*/
    @Test
    public void testEmptyList() {
        List<String> a=new ArrayList();
       List b=  a.stream().limit(0).collect(Collectors.toList());

        System.out.println(b.size()+"  b=="+b);
    }
    /**对中文以及特殊字符做转义
     * URLEncoder.encode 国际通用的编码对中文支持不好，所以需要进行转换
     * */
    @Test
    public void testEncode() {
        String h5Url="http://www.baidu.com?name='你好'";
        try {
            h5Url=URLEncoder.encode(h5Url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("h5Url:  "+h5Url);
    }


}
