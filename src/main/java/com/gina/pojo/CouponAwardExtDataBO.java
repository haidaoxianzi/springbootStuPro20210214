package com.gina.pojo;

import lombok.Data;

/**
 * @ author: zhangkai
 * @ desc: 优惠券扩展信息
 * @ date:create in 3:41 PM 2019/6/6
 */
@Data
public class CouponAwardExtDataBO {
    /**
     * 优惠券批次id
     */
    private Long couponBatchId;

    /**
     * 跳转类型
     */
    private Integer skipType;
    /**
     * 跳转链接
     */
    private String skipUrl;
}
