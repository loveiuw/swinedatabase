package com.example.fsmmdatabasemanager.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")

public class IndexController {

//    @ResponseBody
//    public ModelAndView index(){
//        return new ModelAndView("index");
//    }
    @GetMapping("")
    public String index(){
        return "index";
    }

}
