package xyz.shi.shop.order.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.order.mapper.OrderMapper;
import xyz.shi.shop.order.pojo.Order;
import xyz.shi.shop.order.service.OrderService;
import org.apache.commons.lang3.RandomUtils;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Result createOrder(Order orderParams) {
        Order order = new Order();
        order.setCreateTime(System.currentTimeMillis());
        order.setGoodsId(orderParams.getGoodsId());
        order.setUserId(orderParams.getUserId());
        order.setOrderPrice(orderParams.getOrderPrice());
        order.setOrderId(System.currentTimeMillis()+""+orderParams.getUserId()+ ""+RandomUtils.nextInt(1000,9999));
        order.setOrderStatus(0);
        order.setPayStatus(0);
        order.setPayTime(-1L);
        this.orderMapper.insert(order);
        return Result.success(order.getOrderId());
    }
}