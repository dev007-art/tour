package com.andios.tourism.dto.response;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * 商品参数回显
 */
@Data
public class CommodityResDto {
    private Integer id;
    private String name;
    private double buyingPrice;//进价
    private double sellingPrice;//售价
    private String path;//图片路径
    private String describe;//商品描述
    private int stock;//库存

}
