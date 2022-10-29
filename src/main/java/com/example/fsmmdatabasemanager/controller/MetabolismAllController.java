package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.MetabolismAll;
import com.example.fsmmdatabasemanager.service.MetabolismAllService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/table/metabolismall")
public class MetabolismAllController {
    @Resource
    MetabolismAllService metabolismAllService;

    @GetMapping("")
    @ResponseBody
    public ModelAndView MetabolismAllIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("metabolismall");
        Page<MetabolismAll> page = metabolismAllService.getMetabolismAllByPage(pageNum, perPageNum);
        List<MetabolismAll> metabolismAllList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("MetabolismAll_list", metabolismAllList);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }
}
