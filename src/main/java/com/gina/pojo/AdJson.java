package com.gina.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/10/16 - 10 - 16 -5:47
 * Email: wuqiong76@jd.com
 */
@Data
public class AdJson {
    private String name;
    private int age;
    /**
     * 榜单列表一级分类id，网关临时方案，因为上游没办法区分是哪种一级类目。
     * */
    private Long categoryFirstId;





    public static AdJson toAdJson(String json){
      return   JSON.parseObject(json,AdJson.class);
    }

    public static String toJson(AdJson sdJson){
        return JSON.toJSONString(sdJson);
    }
}
