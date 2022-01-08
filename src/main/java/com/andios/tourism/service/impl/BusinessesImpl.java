package com.andios.tourism.service.impl;

import com.andios.tourism.PageReq.PageNumber;
import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.dto.BusinessesRespDto;
import com.andios.tourism.dto.response.UserResp;
import com.andios.tourism.enu.ResponseEnum;
import com.andios.tourism.mapper.BusinessesMapper;
import com.andios.tourism.pojo.BusinessesPojo;
import com.andios.tourism.service.BusinessesService;
import com.andios.tourism.util.token.TokenUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Service
@Log4j2
public class BusinessesImpl implements BusinessesService {
    @Autowired
    BusinessesMapper businessesMapper;
    @Override
    public BaseResponse<UserResp> login(BusinessesRespDto businessesRespDto,HttpServletRequest request) {
        String check = (String) request.getSession().getAttribute("c");
        if(check.equalsIgnoreCase(businessesRespDto.getCheckCode())){
            EntityWrapper entityWrapper = new EntityWrapper();
            entityWrapper.eq("username",businessesRespDto.getUsername()).eq("password",businessesRespDto.getPassword() ).eq("authority", businessesRespDto.getCheckID().get(0));
            List list = businessesMapper.selectList(entityWrapper);
            if(list.size()!=0){
                BusinessesPojo BPJ = (BusinessesPojo)list.get(0);
                UserResp userResp = new UserResp();
                log.info("登录查询返回数据"+ BPJ.toString());
                String token = TokenUtils.getToken(BPJ.toString());
                userResp.setUsername(BPJ.getUsername());
                userResp.setPassword(BPJ.getPassword());
                userResp.setToken(token);
                userResp.setCheckID(BPJ.getAuthority());
                return BaseResponse.successOf(userResp);
            }
            return BaseResponse.message(ResponseEnum.LOGINFAIL);
        }else {
            return BaseResponse.message(ResponseEnum.check);
        }


    }

    @Override
    public BaseResponse<String> register(BusinessesPojo businessesPojo) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("username",businessesPojo.getUsername());
        List list = businessesMapper.selectList(entityWrapper);
        if(list.size()!=0){
            return BaseResponse.successOf(new String("此用户名已存在请重新注册"));
        }else {
            businessesMapper.insert(businessesPojo);
            return BaseResponse.successOf(new String("注册成功"));
        }

    }
}
