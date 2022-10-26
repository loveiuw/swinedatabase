package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Microbe;
import com.example.fsmmdatabasemanager.entity.Swine;
import com.example.fsmmdatabasemanager.repository.MicrobeRepository;
import com.example.fsmmdatabasemanager.repository.SwineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SwineService {
    @Resource
    SwineRepository swineRepository;

    public List<Swine> getAllSwine(){
        return swineRepository.selectList(null);
    }

    public List<Swine> getSwineByPage(int pageNumber, int perPageNum){
        Page<Swine> page = new Page<>(pageNumber, perPageNum);
        swineRepository.selectPage(page, null);
        return page.getRecords();
    }
}
