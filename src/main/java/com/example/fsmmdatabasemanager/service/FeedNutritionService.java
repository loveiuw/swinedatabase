package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.FeedNutrition;
import com.example.fsmmdatabasemanager.repository.FeedNutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedNutritionService {
    @Autowired
    FeedNutritionRepository feedNutritionRepository;

    public List<FeedNutrition> getAllFeedNutrition(){
        return feedNutritionRepository.selectList(null);
    }
}
