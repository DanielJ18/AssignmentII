package com.ssa.controller;

import java.util.HashMap;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class WebsiteController {
	
	@RequestMapping("/about")
    public ModelAndView about(HttpServletRequest request, ModelAndView mv) {
//        if(request.getParameter("name") != null){
  //          mv.addObject("name", request.getParameter("name"));
    //    }
        mv.setViewName("about");
        return mv;
    }
	@RequestMapping("/")
    public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
        if(request.getParameter("name") != null){
            mv.addObject("name", request.getParameter("name"));
        }
        mv.setViewName("home");
        return mv;
	}
	 @RequestMapping("/help")
	   
	   public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
	        
	        HashMap<String, String> helpMessage = new HashMap<String, String>();
	        
	       helpMessage.put("1", "How may I help you?");
	       helpMessage.put("2", "What can I help you find?");
	       helpMessage.put("3", "You Again?");
	       helpMessage.put("4", "Questions?");
	       helpMessage.put("5", "FAQ");
	       
	       if(request.getParameter("id") != null){  
	           
	         String id = request.getParameter("id");
	       
	           mv.addObject("id", id);
	           mv.addObject("desc", helpMessage.get(id));
	           
	       }
	       mv.setViewName("help");
	       return mv;
	   }
}
	