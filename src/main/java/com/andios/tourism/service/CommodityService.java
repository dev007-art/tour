package com.andios.tourism.service;

import com.andios.tourism.PageReq.PageNumber;
import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.common.PageResponse;
import com.andios.tourism.dto.CommodityRespDto;
import com.andios.tourism.dto.CommodityUpdate;
import com.andios.tourism.dto.response.CommodityResDto;
import com.andios.tourism.pojo.CommodityPojo;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface CommodityService {
    void InsertOne(CommodityRespDto commodityResDto) throws IOException;
    BaseResponse<String> DeleteById(Integer id);
    BaseResponse Update(CommodityUpdate commodityUpdate);
    String  SelectById(Integer id);
    List<CommodityPojo> SelectAll(Integer i);
    int SelectCount();
    List<CommodityPojo> fenye(int page);
    List<CommodityPojo> search(String name,Double price);
}
