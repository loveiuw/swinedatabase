package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.entity.FeedNutrition;
import com.example.fsmmdatabasemanager.service.FeedNutritionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/feednutrition")
public class FeedNutritionController {
    @Resource
    FeedNutritionService feedNutritionService;

    @GetMapping("/getbypage")
    public List<FeedNutrition> getFeedNutritionBypage(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        Page<Feed> page = new Page<>(pageNum, perPageNum);
        return feedNutritionService.getFeedNutritionByPage(pageNum, perPageNum);
    }
}
