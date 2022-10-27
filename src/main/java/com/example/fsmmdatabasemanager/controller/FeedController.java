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

    @GetMapping("/delete")
    public void deleteFeed(HttpServletRequest request){
        feedService.delectFeed(Integer.parseInt(request.getParameter("Feed_index")));
    }

    @PostMapping("/update")
    public void updateFeed(HttpServletRequest request){
        Feed feed = new Feed();
        feed.setFeedIndex(Integer.parseInt(request.getParameter("Feed_index")));
        feed.setTag(request.getParameter("tag"));
        feed.setTime(Integer.parseInt(request.getParameter("time")));
        feed.setNurseingFeedPercentage(Float.parseFloat(request.getParameter("Nurseing_feed_percentage")));
        feed.setPhase1FeedPercentage(Float.parseFloat(request.getParameter("Phase_1_feed_percentage")));
        feed.setPhase2FeedPercentage(Float.parseFloat(request.getParameter("Phase_2_feed_percentage")));
        feed.setPhase3FeedPercentage(Float.parseFloat(request.getParameter("Phase_3_feed_percentage")));
        feed.setDayOfIntake(Float.parseFloat(request.getParameter("day_of_intake")));
    }

    @GetMapping("/getbypage")
    public List<Feed> getFeedBypage(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        Page<Feed> page = new Page<>(pageNum, perPageNum);
        return feedService.getFeedByPage(pageNum, perPageNum);
    }

    @GetMapping("/insert")
    public void insertFeed(HttpServletRequest request){
        Feed feed = new Feed();
        feed.setFeedIndex(getMaxId());
        feed.setTag(request.getParameter("tag"));
        feed.setTime(Integer.parseInt(request.getParameter("time")));
        feed.setNurseingFeedPercentage(Float.parseFloat(request.getParameter("Nurseing_feed_percentage")));
        feed.setPhase1FeedPercentage(Float.parseFloat(request.getParameter("Phase_1_feed_percentage")));
        feed.setPhase2FeedPercentage(Float.parseFloat(request.getParameter("Phase_2_feed_percentage")));
        feed.setPhase3FeedPercentage(Float.parseFloat(request.getParameter("Phase_3_feed_percentage")));
        feed.setDayOfIntake(Float.parseFloat(request.getParameter("day_of_intake")));
        feedService.insertFeed(feed);
    }

    @GetMapping("/getmaxid")
    @ResponseBody
    public int getMaxId(){
        return feedService.getMaxFeedId();
    }

}
