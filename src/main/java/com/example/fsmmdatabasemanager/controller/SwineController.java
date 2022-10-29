package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Microbe;
import com.example.fsmmdatabasemanager.entity.Swine;
import com.example.fsmmdatabasemanager.service.SwineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/table/swine")

public class SwineController {
    @Resource
    SwineService swineService;

    @GetMapping("")
    @ResponseBody
    public ModelAndView swineIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("swine");
        Page<Swine> page = swineService.getSwineByPage(pageNum, perPageNum);
        List<Swine> swineList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("swine_list", swineList);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }
}
