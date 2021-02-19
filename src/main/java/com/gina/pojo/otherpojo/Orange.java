package com.gina.pojo.otherpojo;

import com.gina.pojo.SkuInfo;
import com.gina.pojo.WareRanking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/9/24 - 09 - 24 -10:45
 * Email: wuqiong76@jd.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orange {

    private String color;
    private BigDecimal weight;
    private List<SkuInfo> wareRankLists;

    public Orange(String color, BigDecimal weight) {
        this.color = color;
        this.weight = weight;
    }
}
