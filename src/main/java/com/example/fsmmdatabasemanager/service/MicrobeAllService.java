package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.Microbe;
import com.example.fsmmdatabasemanager.entity.MicrobeAll;
import com.example.fsmmdatabasemanager.repository.MicrobeAllRepository;
import com.example.fsmmdatabasemanager.repository.MicrobeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MicrobeAllService {
    @Resource
    MicrobeAllRepository microbeAllRepository;

    public List<MicrobeAll> getAllMicrobe(){
        return microbeAllRepository.selectList(null);
    }
}
