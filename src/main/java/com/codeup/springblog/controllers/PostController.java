package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    //dependency injection
    private final PostRepository postsDao;

    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }

//    @GetMapping("/posts")
//    @ResponseBody
//    public String index(){
//        return "here are all the posts";
//    }


    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

//    @GetMapping("/posts")
//    public String index(Model model){
//        //creating a list of posts to be hardcoded in with post records
////        List<Post> myPosts = postsDao.findAll();
//        //sending over the arraylist to iterate through in html
//        model.addAttribute("posts", postsDao.findAll());
////        model.addAttribute("posts", myPosts);
//        return "posts/index";
//    }
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String create(@PathVariable long id){
//        return "here is a post with id " + id + ".";
//    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        Post pulledPost = postsDao.getOne(id);
//        model.addAttribute("title", pulledPost.getTitle());
//        model.addAttribute("body", pulledPost.getBody());
        model.addAttribute("post", pulledPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "here is the form to create a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert(){
        return "post has been created";
    }


    //a view to edit the post
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        // update our database with the latest title and body form the edit form
        // get the post from the db to edit
        Post postToEdit = postsDao.getOne(id);
        // set the postToEdit title and body with values/parameters from the request
        postToEdit.setTitle(title);
        postToEdit.setBody(body);
        // save the changes in the database
        postsDao.save(postToEdit);
        // redirect show page for the given post
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

}
