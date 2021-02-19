package com.gina.test;

import com.alibaba.fastjson.JSON;
import com.gina.pojo.WareRanking;
import com.gina.pojo.otherpojo.Apple;
import com.gina.pojo.otherpojo.Box;
import com.gina.pojo.otherpojo.Dog;
import com.xstore.game.center.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class TestJava8BiJi {
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
           for(int i=1;i<=list.size();i++){
               wareRankLists.add(new WareRanking("a",i));
           }
            aa.setWareRankLists(wareRankLists);
        }
    }

    @Test
    public void list2Set() {
        //过滤得到重量大于1.2的苹果，然后给满足条件的每个苹果重量都加1，然后得到这些苹果重量的Set集合。
        Set<BigDecimal> weightsSet = list.stream().filter(apple -> {
            return apple.getWeight().compareTo(new BigDecimal("1.2")) > 0;
        }).map(apple -> apple.getWeight().add(BigDecimal.ONE)).collect(Collectors.toSet());
        log.info("list={},weightsSet.size={},weightsSet={}", JSON.toJSONString(list), CollectionUtils.isEmpty(weightsSet) ? 0 : weightsSet.size(), CollectionUtils.isEmpty(weightsSet) ? null : JSON.toJSONString(weightsSet));
    }
    @Test
    public void listToMap() {
        Map<Long, Apple> map = list.stream().collect(Collectors.toMap(Apple::getId, Function.identity()));
        log.info(JSON.toJSONString(map));
    }

    @Test
    public void listToList() {
        //先过滤得到重量大于1.2的，然后给满足条件的每个苹果重量都加1，然后得到这些苹果重量的List集合。
        List<Dog> listDogs = list.stream().filter(apple ->
                apple.getWeight().compareTo(new BigDecimal("1.2")) > 0
        ).map(apple -> {
            return new Dog(apple.getWeight().add(BigDecimal.ONE).doubleValue());
        }).collect(Collectors.toList());
        log.info("listDogs.size={},listDogs={}", CollectionUtils.isEmpty(listDogs) ? 0 : listDogs.size(), CollectionUtils.isEmpty(listDogs) ? null : JSON.toJSONString(listDogs));
    }
    /**
     * forEach改变原List的值
     */
    @Test
    public void dealList() {
        list.forEach(apple -> {
            apple.setWeight(apple.getWeight().add(BigDecimal.ONE));
        });
       log.info("list={}", JSON.toJSONString(list));
    }
    /**
     * map改变原List的值
     * */
    @Test
    public void dealList2() {
        log.info("before list={}",JSON.toJSONString(list));
        List<Object> dealAfterData = list.stream().map(apple -> {
            apple.setWeight(apple.getWeight().add(BigDecimal.ONE));
            return apple;
        }).collect(Collectors.toList());
        log.info("after  list={}",JSON.toJSONString(list));
        log.info("dealAfterData={}",JSON.toJSONString(dealAfterData));
    }
    //不改变list本身的值，处理结果体现在返回值上

    /**
     * c、stream().peek改变原List的值
     * */
    @Test
    public void dealList3() {
        log.info("before list={}",JSON.toJSONString(list));
        List<Object> dealAfterData = list.stream().peek(apple -> {
            apple.setWeight(apple.getWeight().add(BigDecimal.ONE));
        }).collect(Collectors.toList());
        log.info("after  list={}",JSON.toJSONString(list));
        log.info("dealAfterData={}",JSON.toJSONString(dealAfterData));
    }
    //list各种小动作
    /**
     * 倒序排序，得到第一个元素，即得到最重的一个
     */
    @Test
    public void testAppleList() {
        //reversed 降序排
        Apple a = list.stream().sorted(Comparator.comparing(Apple::getWeight).reversed()).findFirst().orElse(null);
        log.info(" singleApple={}",JSON.toJSONString(a));
    }
    @Test
    public void test(){
        Comparator<Apple> comWeight=new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };

    }
    @Test
    public void test2(){

        list.sort((Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight())); //方式1

        // 方式2  Collections.sort(lists,(Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

       log.info("list={}",JSON.toJSONString(list));
    }
    /**
     * 获取集合前3个元素
     */
    @Test
    public void testAppleList2() {
        list = list.stream().limit(3).collect(Collectors.toList());
        log.info(JSON.toJSONString(list));
    }
    /**
     * 关于对象的表达式
     * 笔记已写好，可以直接做笔记
     */
    @Test
    public void testObject() {
        Box box = new Box();
        box.setGoods(null);
        if (box != null) {
            log.info("hasGoods={}",box.hasGoods());
        }
    }

    /**
     * 判断map是否为空的小工具
     */
    @Test
    public void testClazz11() {
        Map aa = null;
        log.info("aa is empty ?{}", MapUtils.isNotEmpty(aa));
    }



    @Test
    public void groupingBy() {
        //保持原来顺序，先添加序号，方便后面无货沉底，有货和无货仍保持上游传过来的顺序
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSortNo(i);
        }
        Map<Boolean, List<Apple>> map = list.stream().collect(Collectors.groupingBy(apple -> apple.getSortNo().equals(0)));
        log.info("SortNo=0 ,true={},false={}",JSON.toJSONString(map.get(true)),JSON.toJSONString(map.get(false)));
    }
    @Test
    public void addWeights() {
        BigDecimal weightAmount = list.stream().map(Apple::getWeight).reduce(BigDecimal.ZERO,BigDecimal::add);

        log.info("weightAmount={}",JSON.toJSONString(weightAmount));

        weightAmount = list.stream().map(Apple::getWeight).collect(Collectors.toList()).stream()
                .reduce((a, b) ->a.add(b)).get();
        log.info("weightAmount2={}",JSON.toJSONString(weightAmount));
    }

    @Test
    public void addWeights2() {
        BigDecimal weightAmount = list.stream().map(Apple::getWeight).collect(Collectors.toList()).stream()
                .reduce((a, b) ->a.add(b)).get();
        log.info("weightAmount={}",JSON.toJSONString(weightAmount));
    }

}
