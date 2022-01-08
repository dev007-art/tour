package com.andios.tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YbackController {
    @RequestMapping("/Yback")
    public String Yback(){
        return "Yback/viewmap";
    }
    @RequestMapping("/Ybacks")
    @ResponseBody
    public String Ybacks(){
        return "Yback/viewmap";
    }
    @RequestMapping("/viewshow")
    public String viewshow(){
        return "redirect:/assert/viewshow.html";
    }
    @RequestMapping("Yview")
    public String Yview(){
        return "Yback/Yview";
    }
    @RequestMapping("Yviews")
    @ResponseBody
    public String Yviews(){
        return "Yback/Yview";
    }
}
