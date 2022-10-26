package com.example.fsmmdatabasemanager.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fsmmdatabasemanager.entity.Admins;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminsRepository extends BaseMapper<Admins> {
}
