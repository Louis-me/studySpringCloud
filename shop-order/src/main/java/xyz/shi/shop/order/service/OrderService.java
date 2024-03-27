package xyz.shi.shop.order.service;


import xyz.shi.shop.common.Result;
import xyz.shi.shop.order.pojo.Order;

public interface OrderService {

    public Result createOrder(Order orderParams);
}