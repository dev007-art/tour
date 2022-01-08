package com.andios.tourism.dto;

import lombok.Data;

@Data
public class CommodityUpdate {
    private int id;
    private String pname;
    private Double sell;
    private Double buy;
    private int stock;
    private Double proceeds;
    private String desc;
}
