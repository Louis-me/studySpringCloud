package xyz.shi.shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shi.shop.app.popj.BuyParams;
import xyz.shi.shop.app.service.BuyService;
import xyz.shi.shop.common.Result;

@RestController
@RequestMapping("buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @PostMapping("submit")
    private Result submitOrder(@RequestBody BuyParams buyParams){
        return buyService.submitOrder(buyParams);
    }
}
