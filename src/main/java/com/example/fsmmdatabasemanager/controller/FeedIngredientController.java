package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.service.FeedIngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/feedingredient")
public class FeedIngredientController {
    @Resource
    FeedIngredientService feedIngredientService;

   @GetMapping("/getbypage")
   public List<FeedIngredient> getFeedIngredientBypage(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
       Page<Feed> page = new Page<>(pageNum, perPageNum);
       return feedIngredientService.getFeedIngredientByPage(pageNum, perPageNum);
   }

   @GetMapping("/delete")
    public void deleteFeedIngredientBy(HttpServletRequest request){
       feedIngredientService.deleteFeedIngredient(Integer.parseInt(request.getParameter("Item")));
   }

}
