package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.Swine;
import com.example.fsmmdatabasemanager.entity.Times;
import com.example.fsmmdatabasemanager.repository.SwineRepository;
import com.example.fsmmdatabasemanager.repository.TimesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TimesService {
    @Resource
    TimesRepository timesRepository;

    public List<Times> getAllTimes(){
        return timesRepository.selectList(null);
    }
}
