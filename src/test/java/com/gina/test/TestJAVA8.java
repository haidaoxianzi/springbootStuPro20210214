package com.gina.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gina.pojo.CookDetailResult;
import com.gina.pojo.CookFood;
import com.gina.pojo.WareRanking;
import com.gina.pojo.otherpojo.Apple;
import com.gina.util.AESUtil;
import com.gina.util.FutrueUtil;
import com.xstore.game.center.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/10/18 - 10 - 18 -22:55
 */
@Slf4j
public class TestJAVA8 {
    /**
     * 接口降级
     */
    @Test
    public void testDownGrade() {
        Apple apple = null;

        String str = (String) FutrueUtil.getDealResult(() -> apple.getColor(), "111", log);
        log.info("降级后默认值：{}", str);
    }

    List<Apple> list = new ArrayList<>();
    List<WareRanking> wareRankList = new ArrayList<>();


    public void iniListData() {
        list.clear();
        WareRanking a = new WareRanking("red1", 1);
        WareRanking b = new WareRanking("red2", 2);
        WareRanking c = new WareRanking("red3", 3);
        WareRanking d = new WareRanking("red4", 4);
        WareRanking e = new WareRanking("red1", 5);

        wareRankList.add(a);
        wareRankList.add(b);
        wareRankList.add(c);
        wareRankList.add(d);
        wareRankList.add(e);
        iniListData2();
    }

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
    }
//*********************************  filter
    /**
     * filter过滤得到list本身
     */
    @Test
    public void filterList() {
        List<Object> filterList = list.stream().filter(apple -> {
            return apple.getWeight().compareTo(new BigDecimal("1.2")) > 0;
        }).collect(Collectors.toList());
        log.info("filterList={}", JSON.toJSONString(filterList));
    }
    /**
     * filter过滤得到满足的元素
     */
    @Test
    public void filterList2() {
        Apple apple2 = list.stream().filter(apple -> {
            return apple.getWeight().compareTo(new BigDecimal("1.2")) > 0;
        }).findFirst().orElse(null);
        log.info("apple={}", null == apple2 ? null : apple2);
    }

    //排序
    @Test
    public void sorted() {
        CookDetailResult cookDetailResult = new CookDetailResult();
        List<CookFood> foods1 = cookDetailResult.getFoods();
        List<CookFood> foods = foods1.stream().sorted(Comparator.comparing(CookFood::getIsMain).reversed()).collect(Collectors.toList());
    }

    @Test
    public void dealCookStepInfoList() {
        List<Apple> wareInfosNew = list;
        List<WareRanking> wareRankingList = new ArrayList<>();

        for (int i = 0; i < wareInfosNew.size(); i++) {
            Apple contentListWareInfo = list.get(i);
            contentListWareInfo.setWareRanking(wareRankList.get(i));
            wareInfosNew.add(contentListWareInfo);
        }
    }

    //空值获取时，是不会报错的。
    @Test
    public void testObjectNull() {
        Apple a = new Apple();
        a.setId(null);
        log.info("a1={}", a.getId());
        log.info("a={}", a.getId().intValue());
    }

    @Test
    public void testTimeOrder() {
        list = list.stream().sorted(Comparator.comparing(Apple::getModifyTime).reversed()).collect(Collectors.toList());
        log.info("1={}", JSON.toJSONString(list));
    }

    @Test
    public void testClazz() {
        Apple a = new Apple();
        System.out.println(Apple.class);//class com.gina.pojo.otherpojo.Apple
    }



    @Test
    public void test1() {
        String a = "V5RwAyCUf7Fc5W_8qsKPfdotfkBsEp8SJ9SOKeiYpdeOWMKqc4BsIuu6tl7yryC2GpusgUL9diMksWWfnpZksnuywr_ZSB11LX64OZ_FZIJEKjjm0iwNBxVuDLdcfQRs";
        String param = AESUtil.decrypt(a);
        log.info("ScanCodeCommonLinkHandler param:{}", param);
        JSONObject jsonObject = JSON.parseObject(param);
        //扫码的业务类型
                /* int commonLinkType = jsonObject.getIntValue("type");
                String transNo = jsonObject.getString("transNo");*/
        Long storeId = jsonObject.getLongValue("storeId");
        Long tenantId = jsonObject.getLongValue("tenantId");
        System.out.println("storeId={" + storeId + "},tenantId={" + tenantId + "}");
    }

    @Test
    public void test123() {
        //保持原来顺序，先添加序号，方便后面无货沉底，有货和无货仍保持上游传过来的顺序
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSortNo(i);
        }
        System.out.println(list);

        System.out.println("11 ===" + JSON.toJSONString(null));

    }
    @Test
    public void test12() {
        list = new ArrayList<>();
        List<Apple> list2 = new ArrayList<>();
        list.addAll(list2);
        System.out.println(list);
    }
    @Test
    public void testParamllel() {
        List<Long> a=list.parallelStream().map(Apple::getId).collect(Collectors.toList());
        log.info(JSON.toJSONString(a));
    }

    /* List<CategoryInfo> categoryInfoList = new ArrayList<>();
    categoryInfoList.add(new CategoryInfo(-1, "全部榜单"));
    //过滤没有内容id的二级类目
    categoryInfoList.addAll(clubDataListResult.getDataInfoList().stream().map(clubDataInfo -> {
            return null != clubDataInfo.getExtData() ? (ClubCategoryInfo) clubDataInfo.getExtData() : null;
        }).filter(Objects::nonNull).filter(clubCategoryInfo -> null != clubCategoryInfo.getContentId()
                && null != clubCategoryInfo.getCategorySecondId()).map(clubCategoryInfo -> {
            CategoryInfo categoryInfo = new CategoryInfo();
            categoryInfo.setName(clubCategoryInfo.getCategoryName());
            categoryInfo.setId(null != clubCategoryInfo.getCategorySecondId() ? clubCategoryInfo.getCategorySecondId().intValue() : null);
            return categoryInfo;
        }).collect(Collectors.toList()));*/

    // 循环 遍历 类型转化 过滤。




}
