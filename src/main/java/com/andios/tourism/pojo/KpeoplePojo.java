package com.andios.tourism.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("peopleflow")
public class KpeoplePojo {
    @TableId(value="pid",type= IdType.AUTO)
    private int pid;
    @TableField("pname")
    private String pname;
    @TableField("flow")
    private int flow;
    @TableField("data")
    private String data;

    public KpeoplePojo() {
    }

}
