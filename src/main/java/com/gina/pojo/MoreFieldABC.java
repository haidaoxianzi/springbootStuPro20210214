package com.gina.pojo;

import com.gina.pojo.otherpojo.Apple;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/9/23 - 09 - 23 -22:00
 * Email: wuqiong76@jd.com
 */
@Data
public class MoreFieldABC {
    private String name;
    private int id;
    // private Date birth;
    private String abc;
    private List<String> strList;
    private List<Apple> appleList;

    public MoreFieldABC(String name, int id, String abc) {
        this.name = name;
        this.id = id;
        this.abc = abc;
    }
}
