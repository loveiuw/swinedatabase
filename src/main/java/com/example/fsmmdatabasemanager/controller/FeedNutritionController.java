package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.entity.FeedNutrition;
import com.example.fsmmdatabasemanager.service.FeedNutritionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/table/feednutrition")
public class FeedNutritionController {
    @Resource
    FeedNutritionService feedNutritionService;

    @GetMapping("")
    @ResponseBody
    public ModelAndView feedNutritionIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("feedNutrition");
        Page<FeedNutrition> page = feedNutritionService.getFeedNutritionByPage(pageNum, perPageNum);
        List<FeedNutrition> feedNutritionList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("feedNutrition_list", feedNutritionList);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }
}
