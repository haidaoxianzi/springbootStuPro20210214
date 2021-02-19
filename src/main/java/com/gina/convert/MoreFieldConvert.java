package com.gina.convert;

import com.gina.pojo.MoreFieldABC;
import com.gina.pojo.MoreFieldAC;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Description:
 * Author: wuqiong
 * Date: 2020/9/23 - 09 - 23 -22:07
 * Email: wuqiong76@jd.com
 */
@Mapper
public interface MoreFieldConvert {
    MoreFieldConvert convert= Mappers.getMapper(MoreFieldConvert.class);
    /**
     * 返回值必须要有空构造
     * */
    MoreFieldAC convertMoreFieldAC(MoreFieldABC moreFieldABC);

}
