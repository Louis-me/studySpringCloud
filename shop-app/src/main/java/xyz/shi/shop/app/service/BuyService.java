package xyz.shi.shop.app.service;

import xyz.shi.shop.app.popj.BuyParams;
import xyz.shi.shop.common.Result;

public interface BuyService {
    Result submitOrder(BuyParams buyParams);
}