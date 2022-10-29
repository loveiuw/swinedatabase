package com.example.fsmmdatabasemanager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fsmmdatabasemanager.entity.Feed;
import com.example.fsmmdatabasemanager.entity.FeedIngredient;
import com.example.fsmmdatabasemanager.service.FeedIngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/table/feedingredient")
public class FeedIngredientController {
    @Resource
    FeedIngredientService feedIngredientService;

    @GetMapping("")
    @ResponseBody
    public ModelAndView feedIngredientIndex(@RequestParam(defaultValue = "1", required = false)int pageNum, @RequestParam(defaultValue = "10", required = false)int perPageNum){
        ModelAndView modelAndView = new ModelAndView("feedingredient");
        Page<FeedIngredient> page = feedIngredientService.getFeedIngredientByPage(pageNum, perPageNum);
        List<FeedIngredient> feedIngredientList = page.getRecords();
        long numOfPages = page.getPages();
        modelAndView.addObject("feedIngredient_list", feedIngredientList);
        modelAndView.addObject("numOfPages", numOfPages);

        return modelAndView;
    }

   @GetMapping("/delete")
    public void deleteFeedIngredientBy(HttpServletRequest request){
       feedIngredientService.deleteFeedIngredient(Integer.parseInt(request.getParameter("Item")));
   }

}
