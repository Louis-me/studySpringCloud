package xyz.shi.shop.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.shi.shop.app.feign.GoodsFeign;
import xyz.shi.shop.app.feign.OrderFeign;
import xyz.shi.shop.app.feign.UserFeign;
import xyz.shi.shop.app.popj.BuyParams;
import xyz.shi.shop.app.service.BuyService;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.common.goods.GoodsBO;
import xyz.shi.shop.common.user.UserBO;
import xyz.shi.shop.order.pojo.Order;

import java.math.BigDecimal;

@Service
public class BuyServiceImpl implements BuyService {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private GoodsFeign goodsFeign;
    @Autowired
    private OrderFeign orderFeign;

    @Override
    public Result submitOrder(BuyParams buyParams) {
        Result<UserBO> userBOResult = userFeign.findUser(buyParams.getUserId());
        if (userBOResult == null || !userBOResult.isSuccess() || userBOResult.getData() == null){
            return Result.fail(10001,"用户不存在");
        }
        UserBO userBO = userBOResult.getData();
        System.out.println(userBO);
        Result<GoodsBO> goodsBOResult = goodsFeign.findGoods(buyParams.getGoodsId());
        System.out.println(goodsBOResult);

        if (goodsBOResult == null || !goodsBOResult.isSuccess() || goodsBOResult.getData() == null){
            return Result.fail(10002,"商品不存在");
        }
        GoodsBO goodsBO = goodsBOResult.getData();
        Integer goodsStock = goodsBO.getGoodsStock();
        if (goodsStock < 0){
            return Result.fail(10003,"商品库存不足");
        }
        BigDecimal goodsPrice = goodsBO.getGoodsPrice();
        BigDecimal account = userBO.getAccount();
        if (account.compareTo(goodsPrice) < 0){
            return Result.fail(10004,"余额不足");
        }
        Order orderParams = new Order();
        orderParams.setUserId(userBO.getId());
        orderParams.setGoodsId(goodsBO.getId());
        orderParams.setOrderPrice(goodsBO.getGoodsPrice());
        Result<String> orderResultString = orderFeign.createOrder(orderParams);
        System.out.println(orderResultString);

        if (orderResultString == null || !orderResultString.isSuccess()){
            return Result.fail(10005,"下单失败");
        }
        String orderId =  orderResultString.getData();

        return Result.success(orderId);
    }
}