package xyz.shi.shop.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.common.goods.GoodsBO;

@FeignClient("shop-goods")
public interface GoodsFeign {

    //调用路径同http访问路径
    @GetMapping("/goods/findGoods/{id}")
    public Result<GoodsBO> findGoods(@PathVariable("id") Long id);
}