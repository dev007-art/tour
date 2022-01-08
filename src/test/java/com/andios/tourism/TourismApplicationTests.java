package com.andios.tourism;

import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.common.wareHouse;
import com.andios.tourism.dto.Echarts;
import com.andios.tourism.dto.Kpeople;
import com.andios.tourism.dto.response.CommodityResDto;
import com.andios.tourism.dto.wareHouseDto;
import com.andios.tourism.mapper.BusinessesMapper;
import com.andios.tourism.mapper.CommodityMapper;
import com.andios.tourism.mapper.EchartsMapper;
import com.andios.tourism.pojo.BusinessesPojo;
import com.andios.tourism.pojo.CommodityPojo;
import com.andios.tourism.pojo.KpeoplePojo;
import com.andios.tourism.service.BusinessesService;
import com.andios.tourism.service.CommodityService;
import com.andios.tourism.service.EchartsService;
import com.andios.tourism.service.KpeopleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TourismApplicationTests {
    @Autowired
    BusinessesMapper businessesMapper;
    @Autowired
    BusinessesService businessesService;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private EchartsMapper echartsMapper;
    @Autowired
    private EchartsService echartsService;
    @Autowired
    private KpeopleService K;
    @Test
    void contextLoads() {
        List<List<Integer>> lists = K.selectAllMonth();
        System.out.println(lists);
    }

}
