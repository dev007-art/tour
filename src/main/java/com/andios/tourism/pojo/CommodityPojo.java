package com.andios.tourism.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

//商品
@Data
@TableName("commodity")
public class CommodityPojo {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("buyingPrice")
    private double buyingPrice;//进价
    @TableField("sellingPrice")
    private double sellingPrice;//售价
    @TableField("path")
    private String path;//图片路径
    @TableField("describe")
    private String desc;//商品描述
    @TableField("stock")
    private int stock;//库
    @TableField("proceeds")
    private Double proceeds;//销量
}
