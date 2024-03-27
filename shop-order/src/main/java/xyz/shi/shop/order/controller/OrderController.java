package xyz.shi.shop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.order.pojo.Order;
import xyz.shi.shop.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("createOrder")
    public Result createOrder(@RequestBody Order orderParams){
        return orderService.createOrder(orderParams);
    }
}