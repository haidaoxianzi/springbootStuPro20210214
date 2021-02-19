package com.gina.pojo.otherpojo;

import com.gina.pojo.WareRanking;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * Author:
 * Date: 2021/02/12
 * Email:
 */
@Data
public class Apple {
    private Long id;
    private Date modifyTime;
    private String color;
    private BigDecimal weight=BigDecimal.TEN;
    private WareRanking wareRanking;
    private List<WareRanking> wareRankLists;
    /**
     * 序号
     */
    private Integer sortNo;

    public Apple(String color, BigDecimal weight,Date modifyTime) {
        this.color = color;
        this.weight = weight;
        this.modifyTime=modifyTime;
    }
    public Apple(Long id,String color, BigDecimal weight,Date modifyTime) {
        this.color = color;
        this.weight = weight;
        this.modifyTime=modifyTime;
        this.id=id;
    }
    public Apple(String color, BigDecimal weight) {
        this.color = color;
        this.weight = weight;
    }
    public Apple(String color) {
        this.color = color;
    }
    public Apple( ) {

    }

    public Apple getApple(String color, BigDecimal weight){
        if(color.equals(this.color) && weight==this.weight){
            return this;
        }

        return null;
    }
}
