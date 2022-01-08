package com.andios.tourism.controller;

import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.dto.BusinessesRespDto;
import com.andios.tourism.dto.response.UserResp;
import com.andios.tourism.pojo.BusinessesPojo;
import com.andios.tourism.service.BusinessesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BusinessesController {

    @Autowired
    BusinessesService businessesService;
    @RequestMapping("/login")
    @ResponseBody
    public BaseResponse<UserResp> login(@RequestBody @Valid BusinessesRespDto businessesRespDto,HttpServletRequest request){
        return businessesService.login(businessesRespDto,request);
    }
    @RequestMapping("/register")
    public BaseResponse<String> register(@RequestBody BusinessesPojo businessesPojo){
        return businessesService.register(businessesPojo);
    }
}
