package com.andios.tourism.common;


import com.andios.tourism.enu.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@EqualsAndHashCode
public class BaseResponse<T> implements Serializable{

    private static final long serialVersionUID = -4611542485930520366L;

    private String code;

    private String msg;

    private T data;


    public static <T> BaseResponse<T> successOf(T t){
    	BaseResponse<T> adapterResponse = new BaseResponse<>();
    	adapterResponse.setCode(ResponseEnum.SUCCESS.getCode());
    	adapterResponse.setMsg(ResponseEnum.SUCCESS.getMsg());
    	adapterResponse.setData(t);
        return adapterResponse;
    }






	public static <T> BaseResponse<T> message(ResponseEnum soaErrorInfo){
        BaseResponse<T> adapterResponse = new BaseResponse<>();
        adapterResponse.setCode(soaErrorInfo.getCode());
        adapterResponse.setMsg(soaErrorInfo.getMsg());
        return adapterResponse;
    }


}
