package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.repository.FeedIngredientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<FeedIngredient> getFeedIngredientByPage(int pageNumber, int perPageNum){
        Page<FeedIngredient> page = new Page<>(pageNumber, perPageNum);
        feedIngredientRepository.selectPage(page, null);
        return page.getRecords();
    }

    public void deleteFeedIngredient(int id){
        feedIngredientRepository.deleteById(id);
    }
}
