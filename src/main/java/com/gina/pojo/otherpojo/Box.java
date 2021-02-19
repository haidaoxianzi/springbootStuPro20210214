package com.gina.pojo.otherpojo;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class Box {
   private Goods goods;

   public boolean hasGoods(){
       /*1 如果非空，返回一个可操作的值, 否则返回一个空的Optional
       Returns:
       an Optional with a present value if the specified value is non - null, otherwise an empty Optional
       2 比如你的是嵌套的数据结构，首先通过map 获取对象的属性goods
       3 再次通过map获取该属性goods的属性appleList, 获取不到则返回null
       4 判断获取到的对象是否为空，通过Optional.ofNullable(object).isPresent();
       来处理*/

       List<Apple> appleList= Optional.ofNullable(this).map(Box::getGoods).map(Goods::getAppleList).orElse(null);
       return Optional.ofNullable(appleList).isPresent();
   }
}
