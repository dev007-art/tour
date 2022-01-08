package com.andios.tourism.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

//用户登录响应参数
@Data
public class BusinessesRespDto {
    private Integer id;
    private String token;
    @NotBlank(message = "账号不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
   /* @NotEmpty(message = "请勾选用户权限")*/
    private List<Integer> checkID;
    private String checkCode;
}
