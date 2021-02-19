package com.gina.test.scheduled.test;

import com.alibaba.fastjson.JSON;
import com.gina.convert.MoreFieldConvert;
import com.gina.pojo.Done4TaskListRequest;
import com.gina.pojo.Done4TaskListResult;
import com.gina.pojo.MoreFieldABC;
import com.gina.pojo.MoreFieldAC;
import com.gina.pojo.otherpojo.Apple;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/9/23 - 09 - 23 -14:55
 * Email: wuqiong76@jd.com
 */
@Slf4j
public class PojoStuTest {

    @Test
    /**对象里直接定义 校验方法，通过对象直接调用，方法里即可使用对象的值做处理*/
    public void test() {
        Done4TaskListRequest a = new Done4TaskListRequest(1111, 2L, null, "str");
        System.out.println(a.validaParam());
    }

    @Test
    /**对象里直接定义 校验方法，通过对象直接调用，方法里即可使用对象的值做处理*/
    public void testToStringMethod() {
        Done4TaskListRequest a = new Done4TaskListRequest(1111, 2L, null, "str");
        System.out.println(a);
        System.out.println(a.toString());
    }


    @Test
    /**子类构造如何能  直接给父类字段赋值 ？
     * 目前没办法
     * */
    public void test1() {
        Done4TaskListResult a = new Done4TaskListResult(true, 1, "str");
        System.out.println(a);
    }


    /**
     * 测试mapStruct  ,a 类 和b 类 不完全相同，从a拷贝到b   ，b里只是  跟a交叉的部分
     * */
    @Test
    public void testMapStruct() {
        MoreFieldABC abc = new MoreFieldABC("name1", 2, "abc3");

        //普通类型的   list  也可以互转
        List<String> listAbc = new ArrayList<String>();
        listAbc.add("1");
        listAbc.add("2");
        listAbc.add("3");
        abc.setStrList(listAbc);

        //组装类型的bean  的  list  也可以互转
        List<Apple> appleList = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++) {
            Apple a=new Apple("red"+i, BigDecimal.valueOf(1.5+i));
            appleList.add(a);
        }
        abc.setAppleList(appleList);

        MoreFieldAC ac = MoreFieldConvert.convert.convertMoreFieldAC(abc);
        log.info("ac={}", JSON.toJSONString(ac));
    }

    /**查找集合中的满足某个条件的第一个元素*/
    @Test
    public void test3() {
        List<Apple> list = new ArrayList<Apple>();
        Apple a = new Apple("red", BigDecimal.valueOf(1.5),null);
        Apple b = new Apple("red1", BigDecimal.valueOf(2),null);
        Apple c = new Apple("red2", BigDecimal.valueOf(2.1),null);
        Apple d = new Apple("red3", BigDecimal.valueOf(2.1),null);

        list.add(b);
        list.add(c);
        list.add(a);
        list.add(d);
        Apple m = list.stream().filter((Apple n) -> n.getColor().equals("red") && n.getWeight().doubleValue() == 1.5).findFirst().get();
        if (m != null) {
            System.out.println(m.toString());
            System.out.println(list.indexOf(m));
        }
    }

    @Test
    public void test4() {
        Apple d=new Apple("aa");
        Apple e=new Apple("bb");
        System.out.println(d);
        d.setWeight(BigDecimal.valueOf(22));//覆盖默认值1
        System.out.println(d);
        a(d,e);//对象赋值，不用返回，直接就能带回来
        System.out.println(d);
    }

    private void a(Apple d,Apple e){
        d.setColor(e.getColor());
    }
    @Test
    public void test22(){
        List<String> listabc = new ArrayList<String>();
        listabc.add("1");
        listabc.add("2");
        listabc.add("3");
        listabc.add("3");
        System.out.println(listabc.lastIndexOf("3"));
        System.out.println(listabc.indexOf("3"));
    }
}