package com.andios.tourism.mapper;

import com.andios.tourism.dto.Echarts;
import com.andios.tourism.pojo.CommodityPojo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EchartsMapper extends BaseMapper<CommodityPojo> {
}
