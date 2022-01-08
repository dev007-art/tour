package com.andios.tourism.controller;

import com.andios.tourism.dto.Echarts;
import com.andios.tourism.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class EchartsController {
    @Autowired
    private EchartsService echarts;

    /**
     * 商品展示
     * @return
     */
    @RequestMapping("/echarts")
    @ResponseBody
    public HashMap<String, Object> echarts(){
        List<Echarts> echart = echarts.selectAll();
        String[] str=new String[echart.size()];
        Double[] proceeds=new Double[echart.size()];
        for (int i=0;i<echart.size();i++){
            str[i]=echart.get(i).getName();
            proceeds[i]=echart.get(i).getValue();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("names",str );
        map.put("proceeds",proceeds );
        return map;
    }
    @RequestMapping("/echart")
    @ResponseBody
    public List<Echarts> echart(){
        return echarts.selectAll();
    }
    @RequestMapping("/viewmoneys")
    @ResponseBody
    public List<Echarts> viewmoney(){
        return echarts.selectAlls();
    }
}
