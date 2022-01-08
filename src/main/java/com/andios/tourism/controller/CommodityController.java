package com.andios.tourism.controller;

import com.andios.tourism.common.BaseResponse;
import com.andios.tourism.dto.CommodityRespDto;
import com.andios.tourism.dto.CommodityUpdate;
import com.andios.tourism.enu.ResponseEnum;
import com.andios.tourism.pojo.CommodityPojo;
import com.andios.tourism.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CommodityController {
    @Autowired
    CommodityService commodityService;
    @RequestMapping("/warehouse")
    public String toWarehouse(){
        return "redirect:/assert/html/Sback/warehouse.html";
    }

    /**
     * 添加商品
     * @param pname
     * @param Jprice
     * @param sell
     * @param file
     * @param num
     * @param desc
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addCommodity",method = RequestMethod.POST)
    @ResponseBody
    public String addCommodity(@RequestParam("pname") String pname, @RequestParam("Jprice") Double Jprice,
                                             @RequestParam("sell") Double sell, @RequestParam("upload") MultipartFile file,
                                             @RequestParam("num") int num, @RequestParam("desc") String desc,HttpServletRequest request) throws IOException {
        double pro =0.0;
        CommodityRespDto commodityResDto = new CommodityRespDto();
        String originalFilename = UUID.randomUUID()+file.getOriginalFilename();
        //String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        String path="D:\\upload"+originalFilename;
        //图片存到d盘
        //file.transferTo(new File(filePath+originalFilename));
        file.transferTo(new File(path+originalFilename));
        commodityResDto.setProceeds(pro);
        commodityResDto.setDesc(desc);
        //commodityResDto.setImg(filePath+originalFilename);
        commodityResDto.setImg(path+originalFilename);
        commodityResDto.setJprice(Jprice);
        commodityResDto.setPname(pname);
        commodityResDto.setNum(num);
        commodityResDto.setSell(sell);
        commodityService.InsertOne(commodityResDto);
        return BaseResponse.message(ResponseEnum.LRCG).getMsg();
    }
    /*
    展示
     */
    @RequestMapping(value = "/showImg/{id}",method = RequestMethod.GET)
    public void showImg(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream;charset=UTF-8");
        String path = commodityService.SelectById(id);
        FileInputStream in;
        in=new FileInputStream(path);
        int i=in.available();
        byte[] bytes = new byte[i];
        in.read(bytes);
        in.close();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
    /**
     * 删除
     */
    @RequestMapping(value = "delete/{id}")
    public String  delete(@PathVariable("id") Integer id, HttpServletRequest r, RedirectAttributes attributes){
        commodityService.DeleteById(id);
        List<CommodityPojo> commodityPojos = commodityService.SelectAll(1);
        r.removeAttribute("commoditys");
        attributes.addFlashAttribute("commoditys", commodityPojos);
        return "redirect:/back";
    }
    @RequestMapping("/update")
    public String update(@RequestParam("id")  int id,@RequestParam("pname") String pname, @RequestParam("Jprice") Double Jprice,
                                       @RequestParam("Xprice") Double sell,@RequestParam("stock")int stock, @RequestParam("num") Double num,@RequestParam("desc") String desc){
        CommodityUpdate commodityUpdate = new CommodityUpdate();
        commodityUpdate.setId(id);
        commodityUpdate.setPname(pname);
        commodityUpdate.setSell(sell);
        commodityUpdate.setBuy(Jprice);
        commodityUpdate.setDesc(desc);
        commodityUpdate.setStock(stock);
        commodityUpdate.setProceeds(num);
        commodityService.Update(commodityUpdate);
       /* return BaseResponse.message(ResponseEnum.GXCG);*/
        return "Sback/editok";
    }
    @RequestMapping("/fenye/{num}")
    public String fenye(@PathVariable("num") int num,HttpServletRequest request) {
        request.getSession().setAttribute("num",num );
        List<CommodityPojo> f = commodityService.fenye(num);
        int i = commodityService.SelectCount();
        int page = 0;
        if (i % 4 != 0) {
            page = i / 4 + 1;
        } else {
            page = i / 4;
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 1; j <= page; j++) {
            list.add(j);
        }
        request.getSession().setAttribute("commoditys", f);
        request.getSession().setAttribute("page", list);
        return "redirect:/back";
    }
    @RequestMapping("/search")
    public String search(@RequestParam("pname")String pname,@RequestParam("market_price") Double price,HttpServletRequest request){
        List<CommodityPojo> search = commodityService.search(pname, price);
        request.getSession().setAttribute("search",search);
        return "Sback/backsearch";
    }

}
