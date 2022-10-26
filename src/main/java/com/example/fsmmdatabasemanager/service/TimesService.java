package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Swine;
import com.example.fsmmdatabasemanager.entity.Times;
import com.example.fsmmdatabasemanager.repository.SwineRepository;
import com.example.fsmmdatabasemanager.repository.TimesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TimesService {
    @Resource
    TimesRepository timesRepository;

    public List<Times> getAllTimes(){
        return timesRepository.selectList(null);
    }

    public List<Times> getTimesByPage(int pageNumber, int perPageNum){
        Page<Times> page = new Page<>(pageNumber, perPageNum);
        timesRepository.selectPage(page, null);
        return page.getRecords();
    }
}
