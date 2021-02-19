package com.gina.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Description:完成任务列表请求dto
 * Author: wuqiong
 * Date: 2020/9/23 - 09 - 23 -14:08
 * Email: wuqiong76@jd.com
 */
@Data
//@Loggable(argsLogLevel = Loggable.Level.INFO)
@Slf4j
public class Done4TaskListRequest {

    public Done4TaskListRequest() {
    }

    public Done4TaskListRequest(Integer actType, Long actId, List<String> outTaskIdList, String pin) {
        this.actType = actType;
        this.actId = actId;
        this.outTaskIdList = outTaskIdList;
        this.pin = pin;
    }

    /**
     * 活动类型，详见com.xstore.game.center.enums.ActTypeEnum
     */
    private Integer actType;

    /**
     * 活动id
     */
    private Long actId;


    /**
     * 外部任务Id
     */
    private List<String> outTaskIdList;



    /**
     * 用户pin
     */
    private String pin;



    public boolean validaParam() {
        log.info("invoke Done4TaskListRequest.validaParam actType is null");
        if (null == this.actType) {
            log.info("invoke Done4TaskListRequest.validaParam actType is null");
            return false;
        }

        if (null == this.actId) {
            log.info("invoke Done4TaskListRequest.validaParam actId is null");
            return false;
        }

        if (null == this.outTaskIdList){
            log.info("invoke Done4TaskListRequest.validaParam outTaskIdList is null");
            return false;
        }



        if (null == this.pin) {
            log.info("invoke Done4TaskListRequest.validaParam pin is null");
            return false;
        }

        return true;
    }
}
