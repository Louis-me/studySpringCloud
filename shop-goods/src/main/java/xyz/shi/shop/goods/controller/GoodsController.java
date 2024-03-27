package xyz.shi.shop.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.goods.service.GoodsService;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("findGoods/{id}")
    public Result findGoods(@PathVariable("id") Long id){
        return goodsService.findGoodsById(id);
    }
}