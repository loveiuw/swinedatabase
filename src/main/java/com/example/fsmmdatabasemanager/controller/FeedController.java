package com.example.fsmmdatabasemanager.controller;

import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/feed")

public class FeedController {
    @Autowired
    FeedService feedService;

    @ResponseBody
    @GetMapping("/selectbyrange")
    public ModelAndView selectFeedByRange(String column, float l, float r){
        List<Feed> list = feedService.selectFeedByRange(column, l, r);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("byrange", list);
        return modelAndView;
    }

}
