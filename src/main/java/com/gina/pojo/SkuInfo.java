package com.gina.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：wuqiong
 * @date ：2021/01/05
 * @description ：
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkuInfo {
    /**
     * 图标
     */
    private String detailRankingImage;
    /**
     * 排行榜顺序
     */
    private Integer rankingOrder;

}
