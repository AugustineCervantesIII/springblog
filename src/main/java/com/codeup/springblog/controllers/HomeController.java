package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

//    @GetMapping("/")
//    @ResponseBody
//    public String page(){
//        return "this is the landing page."
//    }

    @GetMapping("/")
// @ResponseBody removed to connect a controller to a view on home.html file
    public String page(){
        return "home";
    }

    @PostMapping("/")
    public String returnName(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "home";
    }

}
