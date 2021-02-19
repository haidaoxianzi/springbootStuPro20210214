package com.gina.pojo.request;

import lombok.Data;

/**
 * Description:家万佳会员信息
 * Author: wuqiong
 * Date: 2020/11/3 - 11 - 03 -18:01
 * Email: wuqiong76@jd.com
 */
@Data
public class JwjMemberInfo {
    /**
     * 脱敏后名称
     * */
    private String encryptName;
    /**
     * 脱敏后手机号
     * */
    private String encryptPhone;
    /**
     *  卡号
     * */
    private String cardNo;

}
