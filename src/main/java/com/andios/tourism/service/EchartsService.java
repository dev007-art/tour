package com.andios.tourism.service;

import com.andios.tourism.dto.Echarts;

import java.util.List;

public interface EchartsService {
    //销量
    List<Echarts> selectAll();
    //所得钱
    List<Echarts> selectAlls();
}
