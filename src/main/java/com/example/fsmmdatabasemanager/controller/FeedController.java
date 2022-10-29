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
@RequestMapping("table/feed")

public class FeedController {
    @Autowired
    FeedService feedService;

    @GetMapping("/")
    @ResponseBody
    public ModelAndView feedIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("feed");
        Page<Feed> page = feedService.getFeedByPage(pageNum, perPageNum);
        List<Feed> feedList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("feed_list", feedList);
        modelAndView.addObject("numOfPages", numOfPages);

        System.out.format("Get Feed!!! Lenth of data: %d\n", feedList.size());
        return modelAndView;
    }

    @GetMapping("/delete")
    public void deleteFeed(HttpServletRequest request){
        feedService.delectFeed(Integer.parseInt(request.getParameter("Feed_index")));
    }

    @PostMapping("/update")
    public ModelAndView updateFeed(HttpServletRequest request, @RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        Feed feed = new Feed();
        feed.setFeedIndex(Integer.parseInt(request.getParameter("Feed_index")));
        feed.setTag(request.getParameter("tag"));
        feed.setTime(Integer.parseInt(request.getParameter("time")));
        feed.setNurseingFeedPercentage(Float.parseFloat(request.getParameter("Nurseing_feed_percentage")));
        feed.setPhase1FeedPercentage(Float.parseFloat(request.getParameter("Phase_1_feed_percentage")));
        feed.setPhase2FeedPercentage(Float.parseFloat(request.getParameter("Phase_2_feed_percentage")));
        feed.setPhase3FeedPercentage(Float.parseFloat(request.getParameter("Phase_3_feed_percentage")));
        feed.setDayOfIntake(Float.parseFloat(request.getParameter("day_of_intake")));
        feedService.updateFeed(feed);
        ModelAndView modelAndView = new ModelAndView("feed");
        Page<Feed> page = feedService.getFeedByPage(pageNum, perPageNum);
        modelAndView.addObject("feed_list", page.getRecords());
        modelAndView.addObject("numOfPage", page.getPages());
        return modelAndView;
    }

    @GetMapping("/add")
    public void insertFeed(HttpServletRequest request){
        Feed feed = new Feed();
        feed.setFeedIndex(getMaxId() + 1);
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
