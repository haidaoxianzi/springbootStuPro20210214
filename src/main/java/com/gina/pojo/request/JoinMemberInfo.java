package com.gina.pojo.request;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Description:用户入会信息
 * Author: wuqiong
 * Date: 2020/11/5 - 11 - 05 -17:03
 * Email: wuqiong76@jd.com
 */
@Data
public class JoinMemberInfo {

    /**
     * 入会渠道:
     * 小程序为0，导购码为1，主站为2，其他为3,
     * 收银台为4、PC收银为5、家万佳11
     */
    private String joinChannel;

    /**
     * 入会方式： 1开卡入会
     */
    private String joinType;

    /**
     * 入会门店:门店id
     */
    private String joinStore;

    public boolean validate() {
        if (StringUtils.isEmpty(joinChannel)) {
            return false;
        }
        if (StringUtils.isEmpty(joinType)) {
            return false;
        }
        if (StringUtils.isEmpty(joinStore)) {
            return false;
        }

        return true;
    }
}
