package com.andios.tourism.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import javax.validation.constraints.NotBlank;

//商家
@Data
@TableName("businesses")
public class BusinessesPojo {
    @TableId(value="id",type= IdType.AUTO)
    private int id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("authority")
    private int authority;
}
