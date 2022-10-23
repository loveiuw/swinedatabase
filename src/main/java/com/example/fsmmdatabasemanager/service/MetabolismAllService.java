package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.MetabolismAll;
import com.example.fsmmdatabasemanager.repository.MetabolismAllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetabolismAllService {
    @Autowired
    MetabolismAllRepository metabolismAllRepository;

    public List<MetabolismAll> getAllMetabolismAll(){
        return metabolismAllRepository.selectList(null);
    }
}
