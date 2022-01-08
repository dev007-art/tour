package com.andios.tourism.service;

import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.dto.Kpeople;
import com.andios.tourism.pojo.BusinessesPojo;
import com.andios.tourism.pojo.KpeoplePojo;

import java.util.List;
import java.util.Map;

public interface KpeopleService {
    void InsertOne(KpeoplePojo kpeoplePojo);
     List<KpeoplePojo> selectAll(String name);
     List<BusinessesPojo> selectAll();
    List<BusinessesPojo> selectAlls();
    BaseResponse<String> DeleteById(Integer id);
    void Update(Kpeople kpeople);
    List<List<Integer>> selectAllMonth();
}
