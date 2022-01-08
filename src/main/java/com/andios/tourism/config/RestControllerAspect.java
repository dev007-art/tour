package com.andios.tourism.config;

import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.enu.ResponseEnum;
import com.andios.tourism.exception.MyServiceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Objects;

@RestControllerAdvice
//@ControllerAdvice
@Log4j2
public class RestControllerAspect {

	public RestControllerAspect() {
		super();
		log.info("加载异常捕获类");
	}


	@ExceptionHandler({ NoHandlerFoundException.class })
	@ResponseBody
	public BaseResponse noHandlerFound(NoHandlerFoundException e) {
		log.info("校验异常11", e);
		return BaseResponse.message(ResponseEnum.FAIL);
	}

	@ExceptionHandler({ IllegalArgumentException.class })
	@ResponseBody
	public BaseResponse illegalArgumentException(IllegalArgumentException e) {
		log.info("校验异常1", e);
		BaseResponse<String> BaseResponse = new BaseResponse<>();
		BaseResponse.setCode(ResponseEnum.FAIL.getCode());
		BaseResponse.setMsg(e.getMessage());
		return BaseResponse;
	}

	@ResponseBody
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public BaseResponse validationException(MethodArgumentNotValidException e) {
		log.info("------------检验异常----------");
		BaseResponse<String> BaseResponse = new BaseResponse<>();
		BaseResponse.setCode(ResponseEnum.FAIL.getCode());
		List<FieldError> fieldErrors = e.getFieldErrors();
		StringBuilder sb = new StringBuilder();
		for (FieldError fe:fieldErrors) {
			sb.append(fe.getDefaultMessage());
		}
		BaseResponse.setData(e.getMessage());
		BaseResponse.setMsg(sb.toString());
		return BaseResponse;
	}

	@ResponseBody
	@ExceptionHandler({ MyServiceException.class })
	public BaseResponse erpException(MyServiceException e) {
		log.info("自定义业务异常", e);
		BaseResponse<String> BaseResponse = new BaseResponse<>();
		BaseResponse.setCode(e.getCode());
		BaseResponse.setMsg(e.getMsg());
		return BaseResponse;
	}
	

	@ResponseBody
	@ExceptionHandler({ HttpMessageNotReadableException.class })
	public BaseResponse erpException(HttpMessageNotReadableException e) {
		log.info("参数错误", e);
		BaseResponse<String> BaseResponse = new BaseResponse<>();
		BaseResponse.setCode(ResponseEnum.FAIL.getCode());
		BaseResponse.setMsg("参数有误");
		return BaseResponse;
	}

	
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public BaseResponse commonException(Exception e) {
		log.info("系统异常", e);
		BaseResponse<String> BaseResponse = new BaseResponse<>();
		BaseResponse.setCode(ResponseEnum.FAIL.getCode());
		BaseResponse.setMsg("系统异常");
		return BaseResponse;
	}

}
