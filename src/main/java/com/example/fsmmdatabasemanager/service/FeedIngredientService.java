package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.repository.FeedIngredientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class FeedIngredientService {
    @Resource
    FeedIngredientRepository feedIngredientRepository;

    public List<FeedIngredient> getAllFeedIngredient(){
        return feedIngredientRepository.selectList(null);
    }
}
