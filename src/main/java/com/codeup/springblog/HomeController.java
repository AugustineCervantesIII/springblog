package com.codeup.springblog;

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
// responsebody removed to connect a controller to a view on home.html file
    public String page(){
        return "home";
    }

    @PostMapping("/")
    public String returnCohort(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", cohort);
        return "home";
    }

}
