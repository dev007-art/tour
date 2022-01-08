package com.andios.tourism.controller;

import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.dto.Kpeople;
import com.andios.tourism.enu.ResponseEnum;
import com.andios.tourism.pojo.BusinessesPojo;
import com.andios.tourism.pojo.KpeoplePojo;
import com.andios.tourism.service.KpeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class KbackContorller {
    @Autowired
    private KpeopleService kpeopleService;
    @RequestMapping("/peopleadd")
    public String peopleadd(){
        return "Kback/peopleadd";
    }
    @RequestMapping(value = "/peopleAdd",method = RequestMethod.POST)
    @ResponseBody
    public String peopleAdd(@RequestParam("pname") String pname, @RequestParam("flow") int flow,
                                  @RequestParam("time") String time){
        KpeoplePojo kpeople = new KpeoplePojo();
        kpeople.setPname(pname);
        kpeople.setFlow(flow);
        kpeople.setData(time);
        kpeopleService.InsertOne(kpeople);
        return BaseResponse.message(ResponseEnum.LRCG).getMsg();
    }
    @RequestMapping(value = "/datile",method = RequestMethod.GET)
    public String datile(@RequestParam("name") String name, HttpServletRequest request){
        List<KpeoplePojo> kpeoplePojos = kpeopleService.selectAll(name);
        request.getSession().setAttribute("kde", kpeoplePojos);
        return "Kback/KbackDetale";
    }
    @RequestMapping("/Sid")
    public String Sid(HttpServletRequest request){
        List<BusinessesPojo> businessesPojos = kpeopleService.selectAll();
        request.getSession().setAttribute("Sid",businessesPojos );
        return "Kback/Sid";
    }
    @RequestMapping("/Yid")
    public String Yid(HttpServletRequest request){
        List<BusinessesPojo> businessesPojos = kpeopleService.selectAlls();
        request.getSession().setAttribute("Yid",businessesPojos );
        return "Kback/Yid";
    }
    @RequestMapping("/Kpeople")
    public String Kpeople(){
        return "Kback/people";
    }
    @RequestMapping("/Kdelete/{id}")
    public String Kdelete(@PathVariable("id") Integer id){
        BaseResponse<String> stringBaseResponse = kpeopleService.DeleteById(id);
        return "redirect:/Kback";
    }

    @RequestMapping("/Kpeopleedits")
    public String kepeopleedits(@RequestParam("pid")int id,@RequestParam("pname")String pname,@RequestParam("flow") int flow,@RequestParam("time") String data){
        Kpeople kpeople = new Kpeople();
        kpeople.setId(id);
        kpeople.setPname(pname);
        kpeople.setData(data);
        kpeople.setFlow(flow);
        kpeopleService.Update(kpeople);
        return "Kback/editok";
    }
    @RequestMapping("/month")
    @ResponseBody
    public List<List<Integer>> selectAllMonth(){
        List<List<Integer>> lists = kpeopleService.selectAllMonth();
        return lists;
    }
}