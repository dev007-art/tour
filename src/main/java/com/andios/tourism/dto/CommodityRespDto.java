package com.andios.tourism.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CommodityRespDto {
    private String pname;
    private double Jprice;//进价
    private double sell;//售价
    private String  img;//图片
    private int num;//库存
    private String desc;//商品描述
    private double proceeds;
}
