package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.MetabolismAll;
import com.example.fsmmdatabasemanager.repository.MetabolismAllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MetabolismAllService {
    @Autowired
    MetabolismAllRepository metabolismAllRepository;

    public List<MetabolismAll> getAllMetabolismAll(){
        return metabolismAllRepository.selectList(null);
    }

    public List<MetabolismAll> getFeedByPage(int pageNumber, int perPageNum){
        Page<MetabolismAll> page = new Page<>(pageNumber, perPageNum);
        metabolismAllRepository.selectPage(page, null);
        return page.getRecords();
    }
}
