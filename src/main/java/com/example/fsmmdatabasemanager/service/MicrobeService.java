package com.example.fsmmdatabasemanager.service;

import com.example.fsmmdatabasemanager.entity.Metabolism;
import com.example.fsmmdatabasemanager.entity.Microbe;
import com.example.fsmmdatabasemanager.repository.MetabolismRepository;
import com.example.fsmmdatabasemanager.repository.MicrobeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MicrobeService {
    @Resource
    MicrobeRepository MicrobeRepository;

    public List<Microbe> getAllMicrobe(){
        return MicrobeRepository.selectList(null);
    }
}
