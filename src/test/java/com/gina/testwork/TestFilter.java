package com.gina.testwork;

import com.alibaba.fastjson.JSON;
import com.gina.pojo.ClubCategoryInfo;
import com.gina.pojo.GameAwardInfoRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/11/10 - 11 - 10 -10:43
 * Email: wuqiong76@jd.com
 */
@Slf4j
public class TestFilter {
    /**
     * 过滤元素中sendCount为0的元素，得到剩余的list集合
     */
    @Test
    public void testfilter() {
        List<GameAwardInfoRespDTO> list = new ArrayList();
        for (int i = 0; i <= 5; i++) {
            GameAwardInfoRespDTO gameAwardInfoResult = new GameAwardInfoRespDTO();
            gameAwardInfoResult.setActId(Long.valueOf(i));
            gameAwardInfoResult.setSendCount(0L);
            list.add(gameAwardInfoResult);
        }
        list.get(0).setSendCount(1L);


        List<GameAwardInfoRespDTO> list2 = list.stream().filter(gameAwardInfo -> gameAwardInfo.getSendCount() > 0).collect(Collectors.toList());
        System.out.println(list2);
    }


    @Test
    public void test1() {
        //String str="https://m.360buyimg.com/pop/jfs/t1/142686/32/13339/195508/5fa3c5a2E0d6c3f32/29d122e9b3d974c8.jpg!cc_4x3";
        String str = "https://m.360buyimg.com/pop/jfs/t1/142686/32/13339/195508/5fa3c5a2E0d6c3f32/29d122e9b3d974c8.jpg";
        // System.out.println( str.substring(0,str.lastIndexOf("!cc_")));
        String[] aa = "".split("!cc_");
        System.out.println(aa[0] + "    ,");
    }

    @Test
    public void test2() {
        ClubCategoryInfo clubCategoryInfo = new ClubCategoryInfo();
        try {
            List<String> images = new ArrayList<String>();
            images.add("1");
            images.add(null);
            images.add("2");
            images.add("3");
            clubCategoryInfo.setImages(images);
            log.info("1   " + JSON.toJSONString(clubCategoryInfo.getImages()));
            /*clubCategoryInfo.getImages().stream().map(image -> {
                return StringUtils.isEmpty(image) ? image : image.split("!cc_")[0] + "!q70.webp";
            }).collect(Collectors.toList());*/
            clubCategoryInfo.getImages().stream().map(image ->  image.split("!cc_")[0] + "!q70.webp").collect(Collectors.toList());
            log.info("2   " + JSON.toJSONString(clubCategoryInfo.getImages()));
        } catch (Exception e) {
            System.out.println(e);
            log.info(JSON.toJSONString(clubCategoryInfo.getImages()), e);

        }
    }


    @Test
    public void test3() {
        String  aa = "1.3345";
        System.out.println(aa.length());
        if(aa.length()>4){
            aa=aa.substring(0,4);
            System.out.println(aa);
        }
    }
}
