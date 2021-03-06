package com.andios.tourism.controller;

import com.andios.tourism.pojo.CommodityPojo;
import com.andios.tourism.service.CommodityService;
import com.andios.tourism.service.KpeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class indexController {
    @Autowired
    private KpeopleService kpeopleService;
    @Autowired
    private CommodityService commodityService;
    @RequestMapping("/")
    public String index(){
            return "login";
    }
    @RequestMapping("/back")
    public String success(HttpServletRequest request){
        int i = commodityService.SelectCount();
        int page=0;
        if(i%4!=0){
            page=i/4+1;
        }else {
            page=i/4;
        }
        List<Integer> list =new ArrayList<>();
        for(int j=1;j<=page;j++){
            list.add(j);
        }
        Integer num = (Integer) request.getSession().getAttribute("num");
        if(num==null){
            List<CommodityPojo> commodityPojos = commodityService.SelectAll(1);
            request.getSession().setAttribute("commoditys",commodityPojos );
            request.getSession().setAttribute("page",list);
            return "back";
        }else{
            List<CommodityPojo> commodityPojos = commodityService.SelectAll(num);
            request.getSession().setAttribute("commoditys",commodityPojos );
            request.getSession().setAttribute("page",list);
            return "back";
        }
    }
    @RequestMapping("/productadd")
    public String productadd(){
        return "Sback/productadd";
    }
    @RequestMapping("/productedit")
    public String productedit(){
        return "Sback/productedit";
    }
    @RequestMapping("/check")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int width=100;
        int height=50;
        //1.?????????????????????????????????(?????????????????????)
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //2.????????????
        //2.1???????????????
        Graphics graphics = bufferedImage.getGraphics();//????????????
        graphics.setColor(Color.PINK);//??????????????????
        graphics.fillRect(0,0,width,height);
        //2.2?????????
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz1234567890";
        //??????????????????
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        //2.3????????????
        for (int i=1;i<4;i++){
            int index = random.nextInt(str.length());
            //????????????
            char c = str.charAt(index);
            stringBuilder.append(c);
            graphics.drawString(c+"",width/5*i,height/2);
        }
        String checkCode_Session = stringBuilder.toString();
        //??????????????????Session
        request.getSession().setAttribute("c",checkCode_Session);
        //2.4????????????
        graphics.setColor(Color.GREEN);
        //?????????????????????
        for (int i=0;i<=5;i++){
            int x1 = random.nextInt(width); int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);int y2 = random.nextInt(height);
            graphics.drawLine(x1,x2,y1,y2);
        }
        //3.??????????????????????????????
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }
    @RequestMapping("/viewmoney")
    public String viewmoney(){
        return "Sback/viewmoney";
    }
    @RequestMapping("/viewproduct")
    public String viewproduct(){
        return "Sback/viewproduct";
    }
    @RequestMapping("/Kback")
    public String Kback(){
        return "Kback";
    }
    @RequestMapping("/bianji")
    public String kpeopleedit(){
        return "/Kback/peopleedit";
    }
}
