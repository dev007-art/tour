package com.andios.tourism.service.impl;

import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.dto.Kpeople;
import com.andios.tourism.enu.ResponseEnum;
import com.andios.tourism.mapper.BusinessesMapper;
import com.andios.tourism.mapper.KpeopleMapper;
import com.andios.tourism.pojo.BusinessesPojo;
import com.andios.tourism.pojo.KpeoplePojo;
import com.andios.tourism.service.KpeopleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KpeopleServiceImpl implements KpeopleService {
    @Autowired
    private KpeopleMapper kpeopleMapper;
    @Autowired
    private BusinessesMapper businessesMapper;
    @Override
    public void InsertOne(KpeoplePojo kpeoplePojo) {
         kpeopleMapper.insert(kpeoplePojo);
    }

    @Override
    public  List<KpeoplePojo> selectAll(String name) {
        EntityWrapper entityWrapper = new EntityWrapper();
        Wrapper pname = entityWrapper.eq("pname", name);
        return kpeopleMapper.selectList(pname);
    }

    @Override
    public List<BusinessesPojo> selectAll() {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("authority", 2);
        List<BusinessesPojo> businessesPojos = businessesMapper.selectList(entityWrapper);
        return businessesPojos;
    }

    @Override
    public List<BusinessesPojo> selectAlls() {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("authority", 3);
        List<BusinessesPojo> businessesPojos = businessesMapper.selectList(entityWrapper);
        return businessesPojos;
    }

    @Override
    public BaseResponse<String> DeleteById(Integer id) {
        kpeopleMapper.deleteById(id);
        return BaseResponse.message(ResponseEnum.SQCG);
    }

    @Override
    public void Update(Kpeople kpeople) {
        KpeoplePojo kpeoplePojo = new KpeoplePojo();
        kpeoplePojo.setPname(kpeople.getPname());
        kpeoplePojo.setData(kpeople.getData());
        kpeoplePojo.setFlow(kpeople.getFlow());
        kpeoplePojo.setPid(kpeople.getId());
        kpeopleMapper.updateByIds(kpeoplePojo);
    }

    @Override
    public List<List<Integer>> selectAllMonth() {
        EntityWrapper entityWrapper1 = new EntityWrapper();
        entityWrapper1.eq("pname","欢乐江城");
        EntityWrapper entityWrapper2 = new EntityWrapper();
        entityWrapper2.eq("pname","渔光岛");
        EntityWrapper entityWrapper3 = new EntityWrapper();
        entityWrapper3.eq("pname","飓风湾");
        EntityWrapper entityWrapper4 = new EntityWrapper();
        entityWrapper4.eq("pname","欢乐时光");
        EntityWrapper entityWrapper5 = new EntityWrapper();
        entityWrapper5.eq("pname","甜品王国");

        List<KpeoplePojo> kpeoplePojo1 = kpeopleMapper.selectList(entityWrapper1);
        List<KpeoplePojo> kpeoplePojo2 = kpeopleMapper.selectList(entityWrapper2);
        List<KpeoplePojo> kpeoplePojo3 = kpeopleMapper.selectList(entityWrapper3);
        List<KpeoplePojo> kpeoplePojo4 = kpeopleMapper.selectList(entityWrapper4);
        List<KpeoplePojo> kpeoplePojo5 = kpeopleMapper.selectList(entityWrapper5);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        for(int i=0;i<kpeoplePojo1.size();i++){
            list1.add(kpeoplePojo1.get(i).getFlow());
        }
        for(int i=0;i<kpeoplePojo2.size();i++){
            list2.add(kpeoplePojo2.get(i).getFlow());
        }
        for(int i=0;i<kpeoplePojo3.size();i++){
            list3.add(kpeoplePojo3.get(i).getFlow());
        }
        for(int i=0;i<kpeoplePojo4.size();i++){
            list4.add(kpeoplePojo4.get(i).getFlow());
        }
        for(int i=0;i<kpeoplePojo5.size();i++){
            list5.add(kpeoplePojo5.get(i).getFlow());
        }
        List<List<Integer>> list= new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        return list;
    }

}
