package com.example.fsmmdatabasemanager.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fsmmdatabasemanager.entity.Feed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FeedRepository extends BaseMapper<Feed> {
    @Select("select * from feed where ${column} >= #{l} and ${column} <= #{r}")
    List<Feed> selectFeedByRange(String column, float l, float r);
}
