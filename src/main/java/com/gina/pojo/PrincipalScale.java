/*
package com.gina.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ms.ebdt.json.util.exception.PlatformException;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;

public class PrincipalScale {
    public static Log logger = LogFactory.getLog(PrincipalScale.class);

    */
/**
     * 期数
     *//*

    private int phaseNumber;

    */
/**
     * 本金百分比
     *//*

    private BigDecimal prinScale;

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public void setPhaseNumber(int phaseNumber) {
        this.phaseNumber = phaseNumber;
    }

    public BigDecimal getPrinScale() {
        return prinScale;
    }

    public void setPrinScale(BigDecimal prinScale) {
        this.prinScale = prinScale;
    }

    @Override
    public String toString() {
        return "PrincipalScale [phaseNumber=" + phaseNumber + ", prinScale=" + prinScale + "]";
    }

    */
/**
     *  dto转换成json数据
     * @param protocol
     * @return
     *//*

    public static String toJson(PrincipalScale dto) {

        return JSON.toJSONString(dto);
    }

    */
/**
     * 将json数据转换成 bean
     * @param json
     * @return
     * @throws PhaseException
     *//*

    public static PrincipalScale JsonStrtoBean(String jsonStr) {
        try {
            if (jsonStr == null) {
                throw new PlatformException("参数为空");
            }
            */
/*PrincipalScale printScale = (PrincipalScale) net.sf.json.JSONObject.toBean(jsonObject,
                    PrincipalScale.class);*//*

            PrincipalScale dto = JSONObject.parseObject(jsonStr, PrincipalScale.class);
            return dto;
        } catch (Exception e) {
            logger.info("获取数据出现异常：" + e.getMessage() + ";" + jsonStr);
            return null;
        }
    }

    */
/**
     * 将json数据转换成 bean
     * @param json
     * @return
     * @throws PhaseException
     *//*

    public static PrincipalScale JsonObject2toBean(net.sf.json.JSONObject jsonObject) {
        try {
            if (jsonObject == null) {
                throw new PlatformException("参数为空");
            }
            PrincipalScale dto = (PrincipalScale) net.sf.json.JSONObject.toBean(jsonObject, PrincipalScale.class);
            return dto;
        } catch (Exception e) {
            logger.info("获取数据出现异常：" + e.getMessage() + ";" + jsonObject);
            return null;
        }
    }
    */
/*java 字符串转成 json 数组并且遍历
    当需要把一串字符串转成一个json 数组 ，并遍历其中的内容时。

    首先要导入 net.sf.json.JSONArray和net.sf.json.JSONObject 两个jar 包*//*


    public static void main(String[] args) {
        PrincipalScale dto = new PrincipalScale();
        dto.setPhaseNumber(1);
        dto.setPrinScale(new BigDecimal("0.34567"));
        System.out.println(dto.getPrinScale());
        String tostr = toJson(dto);
        System.out.println(tostr);
        PrincipalScale a = JsonStrtoBean(tostr);
        System.out.println(a.getPhaseNumber() + "," + a.getPrinScale() + "***************************");

        String str = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]"; // 一个未转化的字符串

        JSONArray json = JSONArray.fromObject(str); // 首先把字符串转成 JSONArray  对象

        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                net.sf.json.JSONObject job = json.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                System.out.println(job.get("name") + "=" + job.get("value")); // 得到 每个对象中的属性值
            }
        }
    }
}*/
