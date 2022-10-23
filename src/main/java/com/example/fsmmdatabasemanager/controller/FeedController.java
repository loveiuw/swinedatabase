package com.example.fsmmdatabasemanager.controller;

import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/feed")

public class FeedController {
    @Autowired
    FeedService feedService;

    @ResponseBody
    @GetMapping("/")
    public ModelAndView showFeed(String column, float l, float r){
        List<Feed> list = feedService.selectFeedByRange(column, l, r);
        ModelAndView modelAndView = new ModelAndView("Manage");
        modelAndView.addObject("byrange", list);
        modelAndView.addObject("feed_list", feedService.selectALlFeed());
        return modelAndView;
    }

    @GetMapping("/deletefeed")
    public void deleteFeed(int feedId){
        feedService.delectFeed(feedId);
    }

    @PostMapping("/updatefeed")
    public void updateFeed(HttpServletRequest httpServletRequest){
    }

}
