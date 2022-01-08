package com.andios.tourism.service;

import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.dto.BusinessesRespDto;
import com.andios.tourism.dto.response.UserResp;
import com.andios.tourism.pojo.BusinessesPojo;

import javax.servlet.http.HttpServletRequest;

public interface BusinessesService {
   BaseResponse<UserResp> login(BusinessesRespDto businessesRespDto,HttpServletRequest request);
   BaseResponse<String> register(BusinessesPojo businessesPojo);
}
