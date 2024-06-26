package xyz.shi.shop.common.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsBO {

    private Long id;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsStock;
}