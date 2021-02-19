package com.gina.pojo.request;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Description:用户授权信息
 * Author: wuqiong
 * Date: 2020/11/3 - 11 - 03 -13:55
 * Email: wuqiong76@jd.com
 */
@Data
public class JwjUserInfo {

    /**
     * 电话
     */
    private String phone;

    public boolean validate() {
        if(StringUtils.isEmpty(phone)){
            return false;
        }
        return true;
    }
}
