package com.andios.tourism.service.impl;

import com.andios.tourism.dto.Echarts;
import com.andios.tourism.mapper.EchartsMapper;
import com.andios.tourism.pojo.CommodityPojo;
import com.andios.tourism.service.EchartsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EchartsServiceImpl implements EchartsService {
    @Autowired
    private EchartsMapper echartsMapper;
    @Override
    public List<Echarts> selectAll() {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.setSqlSelect("name","proceeds");
        List<Echarts> lists=new ArrayList<>();
        List<CommodityPojo> list = echartsMapper.selectList(entityWrapper);
        for (int i=0;i<list.size();i++){
            Echarts echarts = new Echarts();
            echarts.setName(list.get(i).getName());
            echarts.setValue(list.get(i).getProceeds());
            lists.add(echarts);
        }
        return lists;
    }

    @Override
    public List<Echarts> selectAlls() {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.setSqlSelect("name","proceeds","buyingPrice","sellingPrice");
        List<Echarts> lists=new ArrayList<>();
        List<CommodityPojo> list = echartsMapper.selectList(entityWrapper);
        for (int i=0;i<list.size();i++){
            Echarts echarts = new Echarts();
            echarts.setName(list.get(i).getName());
            echarts.setValue(list.get(i).getProceeds()*(list.get(i).getSellingPrice()-list.get(i).getBuyingPrice()));
            lists.add(echarts);
        }
        return lists;
    }
}
