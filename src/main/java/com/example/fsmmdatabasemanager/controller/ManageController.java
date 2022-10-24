package com.example.fsmmdatabasemanager.controller;

import com.example.fsmmdatabasemanager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")

public class ManageController {
    @Autowired
    FeedService feedService;
    @Autowired
    FeedIngredientService feedIngredientService;
    @Autowired
    FeedNutritionService feedNutritionService;
    @Autowired
    MetabolismService metabolismService;
    @Autowired
    MetabolismAllService metabolismAllService;
    @Autowired
    MicrobeService microbeService;
    @Autowired
    MicrobeAllService microbeAllService;
    @Autowired
    SwineService swineService;
    @Autowired
    TimesService timesService;

    @ResponseBody
    @GetMapping("")
    public ModelAndView getAllData(){
        ModelAndView modelAndView = new ModelAndView("Manage");
        modelAndView.setViewName("Manage");
        modelAndView.addObject("feed_list", feedService.selectALlFeed());
        modelAndView.addObject("feedingredient_list", feedIngredientService.getAllFeedIngredient());
        modelAndView.addObject("feednutrition_list", feedNutritionService.getAllFeedNutrition());
        modelAndView.addObject("metabolism_list", metabolismService.getAllMetabolism());
        modelAndView.addObject("metabolismall_list", metabolismAllService.getAllMetabolismAll());
        modelAndView.addObject("microbe_list", microbeService.getAllMicrobe());
        modelAndView.addObject("microbeall_list", microbeAllService.getAllMicrobe());
        modelAndView.addObject("swine_list", swineService.getAllSwine());
        modelAndView.addObject("times_list", timesService.getAllTimes());
        return modelAndView;
    }
}
