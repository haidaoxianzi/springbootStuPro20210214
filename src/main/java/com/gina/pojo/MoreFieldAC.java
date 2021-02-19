package com.gina.pojo;

import com.gina.pojo.otherpojo.Apple;
import com.gina.pojo.otherpojo.Orange;
import lombok.Data;

import java.util.List;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/9/23 - 09 - 23 -22:06
 * Email: wuqiong76@jd.com
 */
@Data
public class MoreFieldAC {
    private String name;
    private int id;
    private List<String> aList;
    private List<String> strList;
   private List<Orange> appleList;
  //private List<Apple> AppleList;  即便类型不一样，但是变量名称一样，且类型bean 里得属性都一样，也可以拷贝成功
  //private List<Orange> orangeList;  //属性名称，属性类型都不一样，不能拷贝赋值到这里
    private String eee;

    public MoreFieldAC() {
    }

    public MoreFieldAC(String name, int id, String eee) {
        this.name = name;
        this.id = id;
        this.eee = eee;
    }
}
