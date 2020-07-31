package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "here are all the posts";
    }

    @GetMapping("/post/{id}")
    @ResponseBody
    public String create(@PathVariable long id){
        return "here is a post with id " + id + ".";
    }

    @GetMapping("/post/create")
    @ResponseBody
    public String create(){
        return "here is the form to create a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert(){
        return "post has been created";
    }


}
