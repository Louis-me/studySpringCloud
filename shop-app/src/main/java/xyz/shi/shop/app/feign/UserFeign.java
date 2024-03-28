package xyz.shi.shop.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.common.user.UserBO;

@FeignClient("shop-user")
public interface UserFeign {

    //调用路径同http访问路径
    @GetMapping("/user/findUser/{id}")
    public Result<UserBO> findUser(@PathVariable("id") Long id);
}