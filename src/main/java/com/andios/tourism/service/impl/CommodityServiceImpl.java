package com.andios.tourism.service.impl;

import com.andios.tourism.PageReq.PageNumber;
import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.dto.CommodityRespDto;
import com.andios.tourism.dto.CommodityUpdate;
import com.andios.tourism.dto.response.CommodityResDto;
import com.andios.tourism.enu.ResponseEnum;
import com.andios.tourism.mapper.CommodityMapper;
import com.andios.tourism.pojo.CommodityPojo;
import com.andios.tourism.service.CommodityService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 商品的增上改查
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 插入一条商品记录
     * @param
     * @return
     */
    public void InsertOne(CommodityRespDto crd) throws IOException {
        CommodityPojo commodityPojo= new CommodityPojo();
        commodityPojo.setName(crd.getPname());
        commodityPojo.setBuyingPrice(crd.getJprice());
        commodityPojo.setDesc(crd.getDesc());
        commodityPojo.setSellingPrice(crd.getSell());
        commodityPojo.setPath(crd.getImg());
        commodityPojo.setStock(crd.getNum());
        commodityPojo.setProceeds(crd.getProceeds());
        commodityMapper.insert(commodityPojo);
    }

    @Override
    public BaseResponse DeleteById(Integer id) {
        commodityMapper.deleteById(id);
        return BaseResponse.message(ResponseEnum.SQCG);
    }

    @Override
    public BaseResponse Update(CommodityUpdate update) {
        EntityWrapper entityWrapper = new EntityWrapper();
        CommodityPojo commodityPojo = new CommodityPojo();
        commodityPojo.setName(update.getPname());
        commodityPojo.setBuyingPrice(update.getBuy());
        commodityPojo.setSellingPrice(update.getSell());
        commodityPojo.setStock(update.getStock());
        commodityPojo.setDesc(update.getDesc());
        commodityPojo.setProceeds(update.getProceeds());
        entityWrapper.eq("id",update.getId());
        commodityMapper.update(commodityPojo,entityWrapper );
        return BaseResponse.message(ResponseEnum.GXCG);
    }

    @Override
    public String SelectById(Integer id) {
        CommodityPojo commodityPojo = commodityMapper.selectById(id);
        String path = commodityPojo.getPath();
        return path;
    }

    /**
     * 分页查询商品记录
     * @return
     */
    @Override
    public List<CommodityPojo> SelectAll(Integer i) {
        Page<CommodityResDto> page = new Page(i,4);
        List<CommodityPojo> commodityPojos = commodityMapper.selectPage(page, null);
        return commodityPojos;
    }

    @Override
    public int SelectCount() {
        Integer integer = commodityMapper.selectCount(null);
        return integer;
    }

    @Override
    public List<CommodityPojo> fenye(int page) {
        Page<CommodityPojo> f = new Page(page,4);
        return commodityMapper.selectPage(f, null);
    }

    @Override
    public List<CommodityPojo> search(String name,Double price) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("name", name).eq("sellingPrice", price);
        List<CommodityPojo> list = commodityMapper.selectList(entityWrapper);
        return list;
    }


}
