package com.ssa.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WebController {

	
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
	
//	@RequestMapping("/help")
//    public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
//      
//        
//        ArrayList<String> helpMessage = new ArrayList<String>();
//        helpMessage.add("What help ?");
//        helpMessage.add("Google your life away");
//        helpMessage.add("Help who ?");
//        helpMessage.add("Help is in the way....not !!!");
//        helpMessage.add("Help ? I don't need it");
//        
//        
//        
//        mv.setViewName("help");
//        return mv;
//	}

//    @RequestMapping("/help")
//    public String greeting(@RequestParam(value="id", required=false, 
//    defaultValue="World") String id, Model model) {
//        model.addAttribute("id", id);
//        return "help";
//    }
	

        
       
   
    
	
	@RequestMapping("/help")
    
    public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
		
		HashMap<String, String> helpMessage = new HashMap<String, String>();
	    
    	helpMessage.put("1", "What help ?");
    	helpMessage.put("2", "Google your life away !!!");
    	helpMessage.put("3", "Help who ?!!");
    	helpMessage.put("4", "Help is in the way....NOT !!!");
    	helpMessage.put("5", "Help ? you know you don't need it !!");
        
    	if(request.getParameter("id") != null){  
            
          String id = request.getParameter("id");
        
            mv.addObject("id", id);
            mv.addObject("desc", helpMessage.get(id));
            
        }
        mv.setViewName("help");
        return mv;
    }
	
}
	