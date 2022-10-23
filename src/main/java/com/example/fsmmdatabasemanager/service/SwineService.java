package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.Microbe;
import com.example.fsmmdatabasemanager.entity.Swine;
import com.example.fsmmdatabasemanager.repository.MicrobeRepository;
import com.example.fsmmdatabasemanager.repository.SwineRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SwineService {
    @Resource
    SwineRepository swineRepository;

    public List<Swine> getAllSwine(){
        return swineRepository.selectList(null);
    }
}
