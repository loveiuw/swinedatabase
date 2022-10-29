package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.MicrobeAll;
import com.example.fsmmdatabasemanager.service.MicrobeAllService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/table/microbeall")
public class MicrobeAllController {
    @Resource
    MicrobeAllService microbeAllService;

    @GetMapping("")
    @ResponseBody
    public ModelAndView microbeAllIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "50", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("microbeall");
        Page<MicrobeAll> page = microbeAllService.getMicrobeAllByPage(pageNum, perPageNum);
        List<MicrobeAll> microbeAllList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("microbe_list", microbeAllList);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }
}
