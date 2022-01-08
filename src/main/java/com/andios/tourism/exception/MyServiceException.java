package com.andios.tourism.exception;


import com.andios.tourism.enu.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class MyServiceException extends RuntimeException {


    private String code;

    private String msg;

    public MyServiceException(ResponseEnum e){
        super(e.getMsg());
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    public MyServiceException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
