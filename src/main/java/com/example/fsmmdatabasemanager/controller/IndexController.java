package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.entity.FeedNutrition;
import com.example.fsmmdatabasemanager.repository.FeedIngredientRepository;
import com.example.fsmmdatabasemanager.service.FeedIngredientService;
import com.example.fsmmdatabasemanager.service.FeedNutritionService;
import com.example.fsmmdatabasemanager.service.FeedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.List;


@Controller
@RequestMapping("/")

public class IndexController {
    @Resource
    FeedService feedService;
    @Resource
    FeedIngredientService feedIngredientService;
    @Resource
    FeedNutritionService feedNutritionService;
//    @ResponseBody
//    public ModelAndView index(){
//        return new ModelAndView("index");
//    }
    @GetMapping("/table")
    @ResponseBody
    public ModelAndView manageIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("feed");
        List<Feed> feedList = feedService.getFeedByPage(pageNum, perPageNum).getRecords();
        List<FeedIngredient> feedIngredientList = feedIngredientService.getFeedIngredientByPage(pageNum, perPageNum);
        List<FeedNutrition> feedNutritionList = feedNutritionService.getFeedNutritionByPage(pageNum, perPageNum);
        modelAndView.addObject("feed_list", feedList);
        modelAndView.addObject("feedIngredient_list", feedIngredientList);
        modelAndView.addObject("feedNutrition_list", feedNutritionList);

        System.out.format("Get Feed!!! Lenth of data: %d\n", feedList.size());
        return modelAndView;
    }

}
