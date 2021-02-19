package com.gina.pojo.request;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

/**
 * Description:绑定家万佳【富基】会员请求
 * Author: wuqiong
 * Date: 2020/11/3 - 11 - 03 -13:53
 * Email: wuqiong76@jd.com
 */
@Data
public class BindMemberCardRequest {
   private  Set<String> expIds;
    private boolean isBase;
    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 用户pin
     */
    private String pin;

    /**
     * 会员模式 1.平台模式 2.商家模式
     */
    private Integer dimType;

    /**
     * 取决与上面的dimType，若1则填平台id，2则填商家id
     */
    private Long dimId;

    /**
     * 渠道 1.家万佳
     */

    /**
     * 用户授权信息
     */
    private JwjUserInfo userInfo;
    /**
     * 用户入会信息
     */
    private JoinMemberInfo joinMemberInfo;

    public boolean validate() {
        if (null == tenantId) {
            return false;
        }

        if (StringUtils.isEmpty(pin)) {
            return false;
        }

        if (null == dimType) {
            return false;
        }

        if (null == dimId) {
            return false;
        }

        if (!userInfo.validate()) {
            return false;
        }

        if (!joinMemberInfo.validate()) {
            return false;
        }

        return true;
    }
}
