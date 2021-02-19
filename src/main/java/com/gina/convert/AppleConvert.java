package com.gina.convert;

import com.gina.pojo.SkuInfo;
import com.gina.pojo.WareRanking;
import com.gina.pojo.otherpojo.Apple;
import com.gina.pojo.otherpojo.Orange;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description:苹果和橘子  互转
 * Date: 2021/02/12
 * Email:
 */
public class AppleConvert {

    public static Function<Apple, Orange> convertApple = apple -> {
        Orange orange = new Orange();
        orange.setColor(apple.getColor());
        orange.setWeight(apple.getWeight());
        orange.setWareRankLists(AppleConvert.convertAppleWareRankLists.apply(apple.getWareRankLists()));
        return orange;
    };

    public static Function<List<WareRanking>, List<SkuInfo>> convertAppleWareRankLists = source -> {
        source = CollectionUtils.isNotEmpty(source) ? source.stream().filter(Objects::nonNull).collect(Collectors.toList()) : new ArrayList<>();
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }

        List<SkuInfo> target = source.stream().map(wareRanking -> {
            return new SkuInfo(wareRanking.getDetailRankingImage(), wareRanking.getRankingOrder());
        }).collect(Collectors.toList());

        return target;
    };

    public static Function<List<Apple>, List<Orange>> convertAppleList = appleList -> {
        if (CollectionUtils.isEmpty(appleList)) {
            return null;
        }

        return appleList.stream().map(apple -> {
            Orange orange = new Orange();
            orange.setColor(apple.getColor());
            orange.setWeight(apple.getWeight());
            orange.setWareRankLists(AppleConvert.convertAppleWareRankLists.apply(apple.getWareRankLists()));
            return orange;
        }).collect(Collectors.toList());
    };

}
