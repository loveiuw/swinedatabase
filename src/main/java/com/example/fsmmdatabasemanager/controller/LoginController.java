package com.example.fsmmdatabasemanager.controller;

import com.example.fsmmdatabasemanager.service.AdminsService;
import com.example.fsmmdatabasemanager.utils.AjaxResult;
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
    public AjaxResult loginPage(HttpServletRequest request){
        AjaxResult ajaxResult = new AjaxResult();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if(adminsService.logInByAccount(account).getAdminPassword().equals(password))
            ajaxResult.setState("success");
        else
            ajaxResult.setState("error");
        return ajaxResult;
    }

}
