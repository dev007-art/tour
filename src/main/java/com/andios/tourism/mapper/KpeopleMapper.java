package com.andios.tourism.mapper;

import com.andios.tourism.pojo.KpeoplePojo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface KpeopleMapper extends BaseMapper<KpeoplePojo> {
    Integer updateByIds(KpeoplePojo kpeoplePojo);
}
