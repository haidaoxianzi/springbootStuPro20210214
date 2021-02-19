package com.gina.pojo;

import com.jd.abtest.sdk.entity.UserInfo;
import lombok.Data;

/**
 *  ab测实验入参
 *
 * @author shilei90
 * @date 2020/12/03 上午10:21
 */
@Data
public class AbTestExperimentConfig {

    /**
     * 产品线
     */
    private String productId;

    /**
     * 实验id
     */
    private String expId;

    /**
     * 分流key
     */
    private UserInfo userInfo;

    /**
     * 实验名称
     */
    private String experimentalName;

    /**
     * 实验分支key
     */
    private String experimentalBranchKey;
}
