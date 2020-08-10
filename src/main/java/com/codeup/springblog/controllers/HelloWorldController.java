package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/welcome")
    public String welcome(){
        return "main";
    }

    @GetMapping("/newForm")
    public String newForm(){
        return "form";
    }

    @GetMapping("processForm")
    public String processForm(){
        return "helloworld";
    }


}
