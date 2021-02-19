package com.gina.pojo.result;


import lombok.Data;

/**
 * Created by gina
 * 2018 2018/11/1 20:52
 */
@Data
public class BaseResult {

    private boolean success = true;

    private int businessCode=0;// 0 为成功

    private String msg;

    public enum ResultCodeEnum{

        SUCCESS(0,"成功"),
        FAIL(1,"系统异常"),
        PARAM_ERROR(10,"参数错误"),
        ;

        private int code;

        private String desc;

        ResultCodeEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }


    }

}
