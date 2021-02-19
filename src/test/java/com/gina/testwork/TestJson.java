package com.gina.testwork;

import com.alibaba.fastjson.JSON;
import com.gina.pojo.request.BindMemberCardRequest;
import com.gina.pojo.request.JoinMemberInfo;
import com.gina.pojo.request.JwjUserInfo;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/11/9 - 11 - 09 -10:23
 * Email: wuqiong76@jd.com
 */

public class TestJson {
    @Test
    public void test1(){
       /* BindMemberCardRequest bindMemberCardRequest=new BindMemberCardRequest();
        bindMemberCardRequest.setDimId(1L);
        bindMemberCardRequest.setDimType(1);
        bindMemberCardRequest.setPin("pin");
        bindMemberCardRequest.setTenantId(2L);
        JoinMemberInfo joinMemberInfo=new JoinMemberInfo();
        joinMemberInfo.setJoinChannel("JoinChannel");
        joinMemberInfo.setJoinStore("JoinStore");
        joinMemberInfo.setJoinType("JoinType");
        bindMemberCardRequest.setJoinMemberInfo(joinMemberInfo);
        JwjUserInfo userInfo=new JwjUserInfo();
        userInfo.setPhone("12345678901");
        bindMemberCardRequest.setUserInfo(userInfo);
       String data= JSON.toJSONString(bindMemberCardRequest);
        System.out.println(data);*/
        String data="{\"dimId\":1,\"dimType\":1,\"joinMemberInfo\":{\"joinChannel\":\"JoinChannel\",\"joinStore\":\"JoinStore\",\"joinType\":\"JoinType\"},\"pin\":\"pin\",\"tenantId\":2,\"userInfo\":{\"phone\":\"12345678901\"}}\n";
        data= "{\"dimType\":1,\"dimId\":1,\"joinMemberInfo\":[\"join_channel\":11,\"join_type\":1,\"join_store\":196246],\"userInfo\":[\"PHONE\":13931458182]}";
         BindMemberCardRequest bindMemberCardRequest = JSON.parseObject(data, BindMemberCardRequest.class);
        System.out.println(JSON.toJSONString(bindMemberCardRequest));
    }
    @Test
    public void test2(){
      /*  BindMemberCardRequest bindMemberCardRequest=new BindMemberCardRequest();
        bindMemberCardRequest.setDimId(1L);
        bindMemberCardRequest.setDimType(1);
        bindMemberCardRequest.setBase(false);
        System.out.println(JSON.toJSONString(bindMemberCardRequest));*/
        String data="";
        BindMemberCardRequest createExpApiDto=JSON.parseObject(data,BindMemberCardRequest.class);
        System.out.println("11="+createExpApiDto);

        Set<String> expIds=new HashSet<>();
        expIds.add("aaa");
        expIds.add("bbb");
        System.out.println("set="+JSON.toJSONString(expIds));
    }
}
