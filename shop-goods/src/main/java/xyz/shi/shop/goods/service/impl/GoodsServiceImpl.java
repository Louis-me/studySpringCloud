package xyz.shi.shop.goods.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.shi.shop.common.Result;
import xyz.shi.shop.common.goods.GoodsBO;
import xyz.shi.shop.goods.mapper.GoodsMapper;
import xyz.shi.shop.goods.pojo.Goods;
import xyz.shi.shop.goods.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Result findGoodsById(Long id) {
        Goods goods = goodsMapper.selectById(id);
        GoodsBO goodsBO = new GoodsBO();
        BeanUtils.copyProperties(goods,goodsBO);
        return Result.success(goodsBO);
    }
}