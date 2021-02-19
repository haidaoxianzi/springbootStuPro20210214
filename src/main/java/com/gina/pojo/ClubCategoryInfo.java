package com.gina.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: zhangxiaodong
 * @Date: 2019-09-02 15:49
 * @Description: 文章简要内容
 */
@Data
public class ClubCategoryInfo {
    /**
     * 内容ID
     */
    private Long contentId;
    /**
     * 文章类型
     */
    private Integer contentType;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 标题
     */
    private String title;

    /**
     * 序言
     */
    private String preface;
    /**
     * 封面图
     */
    private String coverImg;
    /**
     * 晒单多图
     */
    private List<String> images;
    /**
     * 视频地址
     */
    private String videoUrl;
    /**
     * 分享封面图
     */
    private String shareCoverImg;
    /**
     * 是否加精
     */
    private boolean isCream;
    /**
     * 是否收藏过（请求参数传有用户PIN则判断）
     */
    private boolean collect;
    /**
     * 收藏总数
     */
    private Long collectCount;
    /**
     * 浏览总数
     */
    private Long seeCount;

    /**
     * 文章标签
     */
    private String tags;
    /**
     * 是否点赞
     */
    private Boolean ifLike;
    /**
     * 是否置顶
     */
    private Boolean isTop = false;
    /**
     * 点赞总数
     */
    private Long likeCount;
    /**
     * 排序位置
     */
    private int sort;
    /**
     * 子类型
     */
    private Integer contentSubType = 0;
    /**
     * 图片比例
     */
    private double radio = 1.33;
    /**
     * 话题id
     */
    private Long topicId;
    /**
     * 话题名称
     */
    private String topicName;

    /**
     * 视频宽度
     */
    private String width = "345";

    /**
     * 视频高度
     */
    private String high = "194";

    /**
     * 是否显示 “查看详情” 按钮   超过5个显示:true , 否则不显示:false
     */
    private Boolean isShow = false;

    /**
     * sku商品数量
     */
    private Integer skuCount = 0;

    /**
     * 跳转榜单详情url
     */
    private String jumpUrl;

}
