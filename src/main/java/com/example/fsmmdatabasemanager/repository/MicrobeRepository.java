package com.example.fsmmdatabasemanager.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fsmmdatabasemanager.entity.Microbe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MicrobeRepository extends BaseMapper<Microbe> {
}
