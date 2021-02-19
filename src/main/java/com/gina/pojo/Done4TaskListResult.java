package com.gina.pojo;

import com.gina.pojo.otherpojo.BaseResult;
import lombok.Data;

/**
 * Description:完成任务列表返回值
 * Author: wuqiong
 * Date: 2020/9/23 - 09 - 23 -14:08
 * Email: wuqiong76@jd.com
 */
@Data
public class Done4TaskListResult extends BaseResult {

    /**
     * 用户已完成任务列表
     */
    private String data;

    public Done4TaskListResult() {
    }

    public Done4TaskListResult(boolean success, Integer code, String msg) {
        super(success,code,msg);

    }


}
