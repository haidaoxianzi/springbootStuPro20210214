package com.gina.pojo;

import lombok.Data;

/**
 * @Auther: zhangxiaodong
 * @Date: 2019/1/3 17:45
 * @Description: 菜谱食材
 */
@Data
public class CookFood {

    /**
     * sku列表
     */
    private Long[] skuId;

    /**
     * 食材名称
     */
    private String foodName;

    private String foodUsage;

    /**
     * 食材是否主材  0不是，1是
     */
    private Integer isMain;
}
