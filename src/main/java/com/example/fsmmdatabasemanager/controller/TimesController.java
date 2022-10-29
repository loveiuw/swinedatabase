package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Times;
import com.example.fsmmdatabasemanager.service.TimesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/table/times")

public class TimesController {
    @Resource
    TimesService timesService;

    @GetMapping("")
    @ResponseBody
    public ModelAndView microbeIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("times");
        Page<Times> page = timesService.getTimesByPage(pageNum, perPageNum);
        List<Times> timesList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("times_list", timesList);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }
}
