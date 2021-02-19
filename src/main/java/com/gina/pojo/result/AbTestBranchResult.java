package com.gina.pojo.result;

import lombok.Data;

@Data
public class AbTestBranchResult {

    /**
     * 调用abtest结果
     */
    private boolean result;

    /**
     * 实验名称
     */
    private String experimentName;

    /**
     * 分流结果版本
     */
    private String branchResult;

    /**
     * 埋点
     */
    private String buriedExpLabel;
}
