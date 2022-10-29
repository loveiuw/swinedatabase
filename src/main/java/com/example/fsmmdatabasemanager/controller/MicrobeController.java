package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Microbe;
import com.example.fsmmdatabasemanager.service.MicrobeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/table/microbe")

public class MicrobeController {
    @Resource
    MicrobeService microbeService;

    @GetMapping("")
    @ResponseBody
    public ModelAndView microbeIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "50", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("microbe");
        Page<Microbe> page = microbeService.getMicrobeByPage(pageNum, perPageNum);
        List<Microbe> microbeList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("microbe_list", microbeList);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }
}
