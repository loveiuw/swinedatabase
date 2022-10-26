package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.FeedNutrition;
import com.example.fsmmdatabasemanager.repository.FeedNutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FeedNutritionService {
    @Autowired
    FeedNutritionRepository feedNutritionRepository;

    public List<FeedNutrition> getAllFeedNutrition(){
        return feedNutritionRepository.selectList(null);
    }

    public List<FeedNutrition> getFeedNutritionByPage(int pageNumber, int perPageNum){
        Page<FeedNutrition> page = new Page<>(pageNumber, perPageNum);
        feedNutritionRepository.selectPage(page, null);
        return page.getRecords();
    }
}
