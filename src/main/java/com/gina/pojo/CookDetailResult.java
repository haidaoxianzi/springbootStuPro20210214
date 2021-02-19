package com.gina.pojo;

import com.gina.pojo.result.BaseResult;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @Auther: zhangxiaodong
 * @Date: 2019/1/3 17:44
 * @Description: 菜谱详情内容返回结果
 */
@Data
public class CookDetailResult extends BaseResult {

    /**
     * 内容ID
     */
    private String contentId;
    /**
     * 标题
     */
    private String title;
    /**
     * 序言
     */
    private String preface;
    /**
     * 列表页封面URL
     */
    private String coverImg;

    /**
     * 封面原图
     */
    private String coverImgSource;

    /**
     * 展示食材
     */
    private List<CookFood> foods;
    /**
     * 视频地址
     */
    private String videoUrl;
    /**
     * 文章来源
     */
    private String from;
    /**
     * 文章来源logo
     */
    private String fromLogo;
    /**
     * 标签
     */
    private String tags;
    /**
     * 菜谱烹饪时间
     */
    private String cookTime;
    /**
     * 菜谱烹饪难度
     */
    private String cookDifficult;
    /**
     * 内容正文
     */
    private String content;
    /**
     * 菜谱步骤
     */
   // private List<CookStepInfo> cookStepInfoList;
    /**
     * 详情页URL链接
     */
    private String detailUrl;

    /**
     * 商品id
     */
    private Set<Long> skuIdList;

    /**
     * 商品信息
     */
   // private List<CookWareInfo> wareList;

    /**
     * 是否收藏过（请求参数传有用户PIN则判断）
     */
    private boolean isCollect;

    /**
     * 今日更多美食
     */
  //  private List<CookBaseInfo>  cookBaseInfoList;

    /**
     * 菜谱作者信息
     */
    //private CookBookAuthor author;

    /**
     * 主食材缺货标记文案
     */
    private String mainFoodDesc;

    /**
     * 收藏数
     */
    private Long collectCount;
}
