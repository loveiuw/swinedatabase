package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Metabolism;
import com.example.fsmmdatabasemanager.entity.Microbe;
import com.example.fsmmdatabasemanager.repository.MetabolismRepository;
import com.example.fsmmdatabasemanager.repository.MicrobeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MicrobeService {
    @Resource
    MicrobeRepository MicrobeRepository;

    public List<Microbe> getAllMicrobe(){
        return MicrobeRepository.selectList(null);
    }

    public Page<Microbe> getMicrobeByPage(int pageNumber, int perPageNum){
        Page<Microbe> page = new Page<>(pageNumber, perPageNum);
        MicrobeRepository.selectPage(page, null);
        return page;
    }
}
