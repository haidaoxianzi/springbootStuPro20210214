package com.gina.testjson;

import com.gina.pojo.AdJson;
import org.junit.Test;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/10/16 - 10 - 16 -5:43
 * Email: wuqiong76@jd.com
 */
public class TestJson {

    @Test
    public void testAdJson() {
        AdJson adJson = new AdJson();
        adJson.setAge(1);
        adJson.setCategoryFirstId(11L);
        adJson.setName("abc");
        String a = AdJson.toJson(adJson);
        System.out.println(a);
        AdJson  bdJson=AdJson.toAdJson(a);
        System.out.println(bdJson);
    }
}
