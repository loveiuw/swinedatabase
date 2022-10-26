package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Microbe;
import com.example.fsmmdatabasemanager.entity.MicrobeAll;
import com.example.fsmmdatabasemanager.repository.MicrobeAllRepository;
import com.example.fsmmdatabasemanager.repository.MicrobeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MicrobeAllService {
    @Resource
    MicrobeAllRepository microbeAllRepository;

    public List<MicrobeAll> getAllMicrobe(){
        return microbeAllRepository.selectList(null);
    }

    public List<MicrobeAll> getMicrobeAllByPage(int pageNumber, int perPageNum){
        Page<MicrobeAll> page = new Page<>(pageNumber, perPageNum);
        microbeAllRepository.selectPage(page, null);
        return page.getRecords();
    }
}
