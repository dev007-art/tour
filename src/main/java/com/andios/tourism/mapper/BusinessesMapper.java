package com.andios.tourism.mapper;

import com.andios.tourism.pojo.BusinessesPojo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BusinessesMapper extends BaseMapper<BusinessesPojo> {
}
