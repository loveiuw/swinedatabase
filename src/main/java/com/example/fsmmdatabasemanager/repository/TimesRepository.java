package com.example.fsmmdatabasemanager.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fsmmdatabasemanager.entity.Times;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimesRepository extends BaseMapper<Times> {
}
