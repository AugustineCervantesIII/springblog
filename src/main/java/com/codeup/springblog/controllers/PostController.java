package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
//import java.util.List;

@Controller
public class PostController {

    //dependency injection
    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;
//    private final PostRepository postDao;

    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService){
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
//        this.postDao = postDao;

    }

//    @GetMapping("/posts")
//    @ResponseBody
//    public String index(){
//        return "here are all the posts";
//    }


    @GetMapping("/email")
    public String sendEmail(){
        emailService.prepareAndSend(postsDao.getOne(1L), "First email.", "This is a test");
        return "Check your Mailtrap inbox";
    }

    @GetMapping("/posts")
    public String index(Model model) {
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(loggedInUser);
//        System.out.println(loggedInUser.getUsername());
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

//    old form code version
//    @GetMapping("/posts/create")
//    public String create(){
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/create")
////    @ResponseBody
//    public String insert(@RequestParam String title, @RequestParam String body){
//        User user = usersDao.getOne(1L);
//        Post post = new Post(title, body, user);
//        postsDao.save(post);
//        return "redirect:/posts";
//    }


    @GetMapping("/posts/create")
    public String create(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post post){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = usersDao.getOne(1L);
        post.setAuthor(loggedInUser);
        postsDao.save(post);
        return "redirect:/posts";
    }

// new form method
        @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id, @ModelAttribute Post post) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = usersDao.getOne(1L);
        post.setAuthor(loggedInUser);
        postsDao.save(post);
        return "redirect:/posts/";
    }



    //a view to edit the post
    //old code form
//    @GetMapping("/posts/{id}/edit")
//    public String editForm(@PathVariable long id, Model model){
//        model.addAttribute("post", postsDao.getOne(id));
//        return "posts/edit";
//    }
//
//    @PostMapping("/posts/{id}/edit")
//    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
//        // update our database with the latest title and body form the edit form
//        // get the post from the db to edit
//        Post postToEdit = postsDao.getOne(id);
//        // set the postToEdit title and body with values/parameters from the request
//        postToEdit.setTitle(title);
//        postToEdit.setBody(body);
//        // save the changes in the database
//        postsDao.save(postToEdit);
//        // redirect show page for the given post
//        return "redirect:/posts/" + id;
//    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

}
