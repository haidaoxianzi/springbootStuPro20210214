/*
package com.gina.util;

import com.gina.pojo.PrincipalScale;
import com.jd.security.auth.repak.com.gson.JsonArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.util.Map;

*/
/**
 * 可以参考学习的
 * https://www.cnblogs.com/wangf-keep/p/6480019.html
 * https://www.cnblogs.com/sharpest/p/7844533.html
 * https://www.cnblogs.com/yuxiaoyu/archive/2016/10/09/5941560.html
 * https://www.cnblogs.com/webwangjin/p/6170994.html
 * *//*

*/
/**
 * Description:
 * Author: wuqiong
 * Date: 2020/12/14 - 12 - 14 -8:25
 * Email: wuqiong76@jd.com
 *//*


public class JsonUtil {
     public static Log logger = LogFactory.getLog(PrincipalScale.class);

    public static void main(String[] args) {

        //字符串转json数组并且遍历内容
        Str2JsonArrayAndTraversingJson1();

        //字符串转json数组并且遍历内容 ，把每条json转成实体bean
        Str2JsonArrayAndTraversingPerJsonTransBean2();

        bean2JsonObject3();

        bean2JsonStr4();

        JsonStrtoBean5();

        JsonObject2Bean6();

        catchJsonStrNestJsonStrPervalue7();

        str2MapAndMap2Str8();
    }

    */
/**
     * 字符串转json数组,遍历json数组内容
     * 注意：字符串格式为[{phaseNumber:'a',pri:'12'},{name:'b',value:'34'},{name:'c',value:'56'},{name:'d',value:'78'}]
     *//*

    public static void Str2JsonArrayAndTraversingJson1() {
        logger.info("1 Str2JsonArray  AndTraversingJson  字符串转json数组,遍历json数组内容 ");
        String str = "[{phaseNumber:'1',prinScale:'0.12'},{phaseNumber:'2',prinScale:'0.34'},{phaseNumber:'3',prinScale:'0.56'},{phaseNumber:'4',prinScale:'0.78'}]";
        //字符串转成 JSONArray  对象
        net.sf.json.JSONArray json = JsonArray.fromObject(str);

        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                net.sf.json.JSONObject job = json.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                logger.info("第" + job.get("phaseNumber") + "期，金额比例：" + job.get("prinScale")); // 得到 每个对象中的属性值
            }
        }
    }

    */
/**
     * 字符串转json数组，遍历json数组内容 ,将json对象依次转化成bean形式，好处：数据结构直接能对应上 ，不用转化数据类型
     * 注意：字符串格式为[{phaseNumber:'a',pri:'12'},{name:'b',value:'34'},{name:'c',value:'56'},{name:'d',value:'78'}]
     *//*

    public static void Str2JsonArrayAndTraversingPerJsonTransBean2() {
        logger.info("2 Str2JsonArray  AndTraversingPerJson2Bean   字符串转json数组，遍历json数组内容 ,将json对象依次转化成bean形式");
        String str = "[{phaseNumber:'1',prinScale:'0.12'},{phaseNumber:'2',prinScale:'0.34'},{phaseNumber:'3',prinScale:'0.56'},{phaseNumber:'4',prinScale:'0.78'}]";
        //字符串转成 JSONArray  对象
        net.sf.json.JSONArray json = JSONArray.fromObject(str);
        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                net.sf.json.JSONObject job = json.getJSONObject(i);
                PrincipalScale printScale = (PrincipalScale) JSONObject.toBean(job, PrincipalScale.class);
                logger.info("第" + printScale.getPhaseNumber() + "期，金额比例：" + printScale.getPrinScale()); // 得到 每个对象中的属性值
            }
        }
    }

    */
/**
     * 一般放在实体bean内部 定义
     * dto转换成json对象数据
     *
     * @return
     *//*

    public static void bean2JsonObject3() {
        logger.info("3 bean  toJsonObject ，dto转换成json对象数据");
        PrincipalScale dto = new PrincipalScale();
        dto.setPhaseNumber(1);
        dto.setPrinScale(new BigDecimal("0.56"));
        String str = JSON.toJSONString(dto);
        org.json.JSONObject jsonObj;
        try {
            jsonObj = new org.json.JSONObject(str);
            logger.info(jsonObj.get("phaseNumber") + ":" + jsonObj.get("prinScale"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    */
/**
     * 一般放在实体bean内部 定义
     * dto转换成json字符串数据
     *//*

    public static String bean2JsonStr4() {
        logger.info("4 dto转换成json字符串数据");
        PrincipalScale dto = new PrincipalScale();
        dto.setPhaseNumber(1);
        dto.setPrinScale(new BigDecimal("0.35"));
        String str = JSON.toJSONString(dto);
        logger.info(str);
        return str;
    }

    */
/**
     * 一般放在实体bean内部 定义
     * 好处：数据结构直接能对应上 ，不用转化数据类型
     * 注意：字符串格式为{phaseNumber:'a',pri:'12'}
     * 将json字符串数据转换成 bean
     *//*

    public static PrincipalScale JsonStrtoBean5() {
        logger.info("5 JsonStr to Bean，json串转bean");
        String jsonStr = "{'phaseNumber':'1','prinScale':'0.12'}";
        try {
            if (jsonStr == null) {
                throw new Exception("参数为空");
            }
            PrincipalScale dto = com.alibaba.fastjson.JSONObject.parseObject(jsonStr, PrincipalScale.class);
            logger.info("第" + dto.getPhaseNumber() + "期，金额比例：" + dto.getPrinScale()); // 得到 每个对象中的属性值
            return dto;
        } catch (Exception e) {
            logger.info("获取数据出现异常：" + e.getMessage() + ";" + jsonStr);
            return null;
        }
    }

    */
/**
     * 一般放在实体bean内部 定义
     * 将json对象数据转换成 bean
     *
     * @param json
     * @return
     * @throws PhaseException
     *//*

    public static PrincipalScale JsonObject2Bean6() {
        logger.info("6 JsonObject2Bean，json对象转bean");
        JSONObject json = new JSONObject();
        json.put("phaseNumber", 1);
        json.put("prinScale", 12);
        try {
            if (json == null) {
                throw new PlatformException("参数为空");
            }
            PrincipalScale dto = (PrincipalScale) net.sf.json.JSONObject.toBean(json, PrincipalScale.class);
            logger.info("第" + dto.getPhaseNumber() + "期，金额比例：" + dto.getPrinScale()); // 得到 每个对象中的属性值
            return dto;
        } catch (Exception e) {
            logger.info("获取数据出现异常：" + e.getMessage() + ";" + json);
            return null;
        }
    }

    */
/**
     * 获取json串里的json串某个key对应的value值
     * 获取json里嵌套的json里的一个值
     *//*

    public static void catchJsonStrNestJsonStrPervalue7() {
        logger.info("7 获取json字符串里嵌套的json串的一个值");
        String jsonStr = "{'id':'11','parentId':'root','refObj':{'existType':'exist','deptType':'emp','treeNodeType':'dept'}}";
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        try {
            JSONObject refObj = (JSONObject) jsonObject.get("refObj");
            String existType = refObj.getString("deptType");
            logger.info(existType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */
/**
     * 字符串和map互转
     *//*

    public static void str2MapAndMap2Str8() {
        logger.info("str2MapAndMap2Str8 ，字符串和map互转");
        String json = "{'name':'张三','age':'20','xb':'男','zzmm':'newValue'}";
        //json转成Map
        Map<String, String> value = JSON.parseObject(json, Map.class);
        logger.info("name=" + value.get("name"));

        //map转json
        String toJson = JSON.toJSONString(value);//重新转成json字符串，｛“name”:"张三","age":"20","xb":“男”,"zzmm":"newValue"｝
        logger.info("map转json串===" + toJson);
    }
}

*/
