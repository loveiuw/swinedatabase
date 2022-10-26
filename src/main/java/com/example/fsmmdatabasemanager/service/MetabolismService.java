package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.entity.Metabolism;
import com.example.fsmmdatabasemanager.repository.FeedIngredientRepository;
import com.example.fsmmdatabasemanager.repository.MetabolismRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MetabolismService {
    @Resource
    MetabolismRepository metabolismRepository;

    public List<Metabolism> getAllMetabolism(){
        return metabolismRepository.selectList(null);
    }

    public List<Metabolism> getMetabolismByPage(int pageNumber, int perPageNum){
        Page<Metabolism> page = new Page<>(pageNumber, perPageNum);
        metabolismRepository.selectPage(page, null);
        return page.getRecords();
    }
}
