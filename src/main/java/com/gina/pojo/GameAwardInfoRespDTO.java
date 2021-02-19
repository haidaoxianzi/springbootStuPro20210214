package com.gina.pojo;


import com.xstore.game.center.enums.AwardTypeEnum;
import com.xstore.game.center.utils.JsonUtil;
import lombok.Data;

/**
 * @ author: zhangkai
 * @ desc:活动奖励信息响应DTO
 * @ date:create in 2:30 PM 2019/5/13
 */
@Data
public class GameAwardInfoRespDTO<T> {
    /**
     * 已发奖品数量
     */
    private Long sendCount;
    /**
     * 活动Id
     */
    private Long actId;
}
