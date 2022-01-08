package com.andios.tourism.controller;

import com.andios.tourism.common.wareHouse;
import com.andios.tourism.dto.wareHouseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class wareHouseController {
    @RequestMapping("s")
    @ResponseBody
    public wareHouse<wareHouseDto> wareHouse(){
        wareHouseDto wareHouseDto = new wareHouseDto();
        wareHouseDto.setWid(1);
        wareHouseDto.setWmark("库管正在管理，尚有空位");
        wareHouseDto.setWname("王大小");
        wareHouseDto.setWproduct("口红33只，手账本55本");
        wareHouseDto wareHouseDto1 = new wareHouseDto();
        wareHouseDto1.setWid(2);
        wareHouseDto1.setWname("张三");
        wareHouseDto1.setWproduct("无存放");
        wareHouseDto1.setWmark("正在维修中......");
        return  wareHouse.get(wareHouseDto, wareHouseDto1);
    }
}
