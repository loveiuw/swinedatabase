package com.example.fsmmdatabasemanager.controller;

import com.example.fsmmdatabasemanager.service.AdminsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    AdminsService adminsService;

    @GetMapping("/loginpage")
    public ModelAndView loginPage(HttpServletRequest request){
        ModelAndView modelAndView= new ModelAndView("login");
        modelAndView.addObject("", "");
        return modelAndView;
    }

}
