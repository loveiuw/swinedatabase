package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.entity.Metabolism;
import com.example.fsmmdatabasemanager.repository.FeedIngredientRepository;
import com.example.fsmmdatabasemanager.repository.MetabolismRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MetabolismService {
    @Resource
    MetabolismRepository metabolismRepository;

    public List<Metabolism> getAllMetabolism(){
        return metabolismRepository.selectList(null);
    }
}
