package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/feed")

public class FeedController {
    @Autowired
    FeedService feedService;

    @GetMapping("/deletefeed")
    public void deleteFeed(int feedId){
        feedService.delectFeed(feedId);
    }

    @PostMapping("/updatefeed")
    public void updateFeed(HttpServletRequest httpServletRequest){
    }

    @GetMapping("/getfeedbypage")
    public List<Feed> getFeedBypage(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        Page<Feed> page = new Page<>(pageNum, perPageNum);
        return page.getRecords();
    }

}
