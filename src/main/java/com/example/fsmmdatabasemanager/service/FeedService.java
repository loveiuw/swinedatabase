package com.example.fsmmdatabasemanager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.repository.FeedRepository;
import com.example.fsmmdatabasemanager.utils.FeedEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FeedService {
    @Resource
    FeedRepository feedRepository;

    public void insertFeed(Feed feed){
        feedRepository.insert(feed);
    }

    public List<Feed> selectALlFeed(){
        return feedRepository.selectByMap(new HashMap<>());
    }

    public Page<Feed> getFeedByPage(int pageNumber, int perPageNum){
        Page<Feed> page = new Page<>(pageNumber, perPageNum, false);
        feedRepository.selectPage(page, null);
        return page;
    }

    public List<Feed> selectFeedByRange(String column, float l, float r){
        FeedEnum feedEnum = FeedEnum.getType(column);
        if(!feedEnum.isNumberAttribute())
            return new ArrayList<>();
        return feedRepository.selectFeedByRange(column, l, r);
    }

    public void updateFeed(Feed feed){
        feedRepository.updateById(feed);
    }

    public void delectFeed(int feedId){
        feedRepository.deleteById(feedId);
    }

    public int getMaxFeedId(){
        QueryWrapper<Feed> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("max(Feed_index)");
        return feedRepository.selectList(queryWrapper).get(0).getFeedIndex();
    }

}
