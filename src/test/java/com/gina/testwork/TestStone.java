package com.gina.testwork;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gina.pojo.AbTestExperimentConfig;
import com.gina.pojo.result.AbTestBranchResult;
import com.jd.abtest.sdk.TouchstoneSDK;
import com.jd.abtest.sdk.entity.UserInfo;
import com.jd.abtest.sdk.entity.config.TouchstoneSdkConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TestStone {
    /*  String label = touchstoneSdk.getExpLabel(abTestExperimentConfig.getUserInfo(), abTestExperimentConfig.getExpId(), "base");
           log.info("AmsAbTestRpcImpl->queryAbTestBranch label: {}", label);

   String paramResult = touchstoneSdk.getStringValue(
           abTestExperimentConfig.getExpId()
           , label
           , abTestExperimentConfig.getExperimentalBranchKey(),
           "");*/
    @Test
    public void test() {
        String expId = "7freshPre_350";
        String experimentalBranchKey = "";
        TouchstoneSDK touchstoneSdk = TouchstoneSDK.getInstance();
        TouchstoneSdkConfig config = new TouchstoneSdkConfig(1, TimeUnit.SECONDS, 100);
        touchstoneSdk.init("7freshPre", config);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPin("2402774969wq");
        String label = touchstoneSdk.getExpLabel(
                userInfo, expId, "base");
        log.info("AmsAbTestRpcImpl->queryAbTestBranch label: {}", label);

        String paramResult = touchstoneSdk.getStringValue(
                expId
                , label
                , experimentalBranchKey,
                "");
        System.out.println("paramResult==" + paramResult);
    }

    @Test
    public void test0() {
        String abTestExperimentConfigJson = "{\"productId\":\"7freshPre\",\"experimentalName\":\"CategoryRecommendSpaceNum\",\"experimentalBranchKey\":\"spaceNum\",\"expId\":\"7freshPre_219\"}";
        //"CategoryRecommendSpace,SearchRecommendSpace,SearchUnStock,CartListUnStock,WareDetailMiddle,CategoryAddCartSpace,SearchAddCartSpace,SkuDetailAddCartSpace";
        AbTestExperimentConfig abTestExperimentConfig = JSONObject.parseObject(abTestExperimentConfigJson, AbTestExperimentConfig.class);
        //JSON.parseObject(abTestExperimentConfigJson, AbTestExperimentConfig.class);
        System.out.println(abTestExperimentConfig);


    }

    @Test
    public void test1() {
        System.out.println("1111==" + JSON.toJSONString(null));
    }

    @Test
    public void queryAbTestBranch() {
        // AbTestBranchResult
        AbTestExperimentConfig abTestExperimentConfig = null;
       /* if(Objects.isNull(abTestExperimentConfig)
                ||Objects.isNull(abTestExperimentConfig.getProductId())
                ||Objects.isNull(abTestExperimentConfig.getExpId())
                ||Objects.isNull(abTestExperimentConfig.getExperimentalBranchKey())){
            log.info("AmsAbTestRpcImpl->queryAbTestBranch param have null : {}", JSONObject.toJSONString(abTestExperimentConfig));
            return  ;
        }*/

        AbTestBranchResult abTestBranchResult = new AbTestBranchResult();

        try {
            log.info("AmsAbTestRpcImpl->queryAbTestBranch param: {}", JSONObject.toJSONString(abTestExperimentConfig));
            //获取参数
            TouchstoneSDK touchstoneSdk = TouchstoneSDK.getInstance();
            TouchstoneSdkConfig config = new TouchstoneSdkConfig(1, TimeUnit.SECONDS, 100);
            touchstoneSdk.init(abTestExperimentConfig.getProductId(), config);
            log.info("AmsAbTestRpcImpl->queryAbTestBranch userInfo: {}", abTestExperimentConfig.getUserInfo());
            String label = touchstoneSdk.getExpLabel(abTestExperimentConfig.getUserInfo(), abTestExperimentConfig.getExpId(), "base");
            log.info("AmsAbTestRpcImpl->queryAbTestBranch label: {}", label);

            String paramResult = touchstoneSdk.getStringValue(
                    abTestExperimentConfig.getExpId()
                    , label
                    , abTestExperimentConfig.getExperimentalBranchKey(),
                    "");
            log.info("AmsAbTestRpcImpl->queryAbTestBranch paramResult: {}", paramResult);
            Map<String, String> expIdInfos = new HashMap<>();
            expIdInfos.put(abTestExperimentConfig.getExpId(), label);
            String buriedExpLabel = touchstoneSdk.getBuriedExpLabel(expIdInfos);
            log.info("AmsAbTestRpcImpl->queryAbTestBranch buriedExpLabel: {}", buriedExpLabel);

            //返回参数
            abTestBranchResult.setResult(true);
            abTestBranchResult.setBranchResult(paramResult);
            abTestBranchResult.setExperimentName(abTestExperimentConfig.getExperimentalName());
            abTestBranchResult.setBuriedExpLabel(buriedExpLabel);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("调用abtest异常");
            return;
        }

        log.info("AmsAbTestRpcImpl->queryAbTestBranch abTestOnOffResult: {}", abTestBranchResult);
    }

    /***
     * 仅获取分流版本；和testExpLabel相比，除了少了人群信息外，底层实现没有什么不同
     * */
    @Test
    public void testStringExp() {
        // sdk对象初始化，每个instance都需调用一次
        // getInstance为单例，另有多例getPrototypeInstance提供
        TouchstoneSDK touchstoneSdk = TouchstoneSDK.getInstance();
        // SDK会在本地缓存实验配置，默认缓存超时时间5分钟，缓存20000个实验
        // 示例中的参数，配置缓存超时时间为60秒，缓存容量100个实验
        TouchstoneSdkConfig config = new TouchstoneSdkConfig(60, TimeUnit.SECONDS, 100);

        // expInfoUrl和expCrowdInfoUrl默认为线上域名，访问预发环境，需要覆盖为预发域名。
        config.setExpInfoUrl("http://touchstonev2-info-pre.jd.local/expinfo");
        config.setExpCrowdInfoUrl("http://touchstonev2-info-pre.jd.local/getPersonIds");

        // sfxntest为产品线标识sfxntest
        touchstoneSdk.init("7freshPre", config);
        // 打标服务，用户可以根据需求设置userInfo；expId为创建实验时，平台自动生成的实验ID
        // UserInfo userInfo = new UserInfo("userPin", "userId", "deviceId");
        UserInfo userInfo = new UserInfo("", "", "deviceId123123");
        // 实验ID  7freshPre    7freshPre_11008
        String expId1 = "7freshPre_11008";
        String expId2 = "7freshPre_11006";
        String expId3 = "7freshPre_11010";
        // expParam中 key为实验ID value为兜底版本值
        Map<String, String> expParam = new HashMap<>();

        expParam.put(expId1, "base");
        expParam.put(expId2, "base");
        expParam.put(expId3, "base");
        // labelRes中 key为实验ID value为分流结果。下面为批量接口，批量的含义是一个用户请求参与多个实验，推荐使用。
        Map<String, String> labelRes = touchstoneSdk.batchGetExpLabel(userInfo, expParam);
        // 取参接口,接口参数分别是: 实验id，版本，参数名，兜底值
        /* Boolean booleanParam = touchstoneSdk.getBooleanValue(expId1, labelRes.get(expId1), "key1", false);
            String stringParam = touchstoneSdk.getStringValue(expId1, labelRes.get(expId1), "string1", "no string");
            Double doubleParam = touchstoneSdk.getDoubleValue(expId1, labelRes.get(expId1), "doble1", -1.0);
            Integer intParam = touchstoneSdk.getIntValue(expId1, labelRes.get(expId1), "int1", 0);
        */
        // 获取子午线上报用的埋点标签，getBuriedExpLabel的参数是 key为实验ID value为分流结果 的map，参数里面键值对的数量视实际情况确定
        String buriedExpLabel = touchstoneSdk.getBuriedExpLabel(labelRes);
        log.info("buriedExpLabel={} ,labelRes={}", buriedExpLabel, JSON.toJSONString(labelRes));
    }

    @Test
    public void test12() {
        Map<String, String> labelRes = new HashMap<>();
        labelRes.put("a", "1");
        labelRes.put("b", "2");
        System.out.println(JSON.toJSONString(labelRes));
    }
                /*log.info("buriedExpLabel={},booleanParam={},stringParam={},doubleParam={},intParam={},labelRes={}"
                    ,buriedExpLabel,booleanParam,stringParam,doubleParam,intParam,JSON.toJSONString(labelRes));*/
}
