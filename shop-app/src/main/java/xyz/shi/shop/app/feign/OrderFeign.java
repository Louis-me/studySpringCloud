package xyz.shi.shop.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.order.pojo.Order;

@FeignClient("shop-order")
public interface OrderFeign {

    //调用路径同http访问路径
    @PostMapping("/order/createOrder")
    public Result<String> createOrder(@RequestBody Order orderParams);
}