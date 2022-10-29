package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Metabolism;
import com.example.fsmmdatabasemanager.service.MetabolismService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/table/metabolism")
public class MetabolismController {
    @Resource
    MetabolismService metabolismService;

    @GetMapping("")
    @ResponseBody
    public ModelAndView feedIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("feed");
        Page<Metabolism> page = metabolismService.getMetabolismByPage(pageNum, perPageNum);
        List<Metabolism> metabolismList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("metabolism_list", metabolismList);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }
}
