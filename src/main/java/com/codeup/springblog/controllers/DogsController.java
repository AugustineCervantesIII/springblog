package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Dogs;
import com.codeup.springblog.repositories.DogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DogsController {

    //dependency injection
    private final DogRepository dogsDao;
    //if another dao
//   private final PostRepository postDao


    //PostRepository dogsDao inside the parameter
    // and this.postDao = postDao;
    public DogsController(DogRepository dogsDao){
        this.dogsDao = dogsDao;
    }

    //to get one id in dogs
    @GetMapping("/dogs/{id}")
    @ResponseBody
    public String getDogs(@PathVariable long id){
        return dogsDao.getOne(id).toString();
    }

    //to return json
    @GetMapping("/dogs")
    @ResponseBody
    //returning a json response
    public List<Dogs> getDogs(){
        return dogsDao.findAll();
    }

    //return a view
    @GetMapping("/dogs/view")
    public String getDogsIndex(Model model){
        model.addAttribute("dogs", dogsDao.findAll());
        return "dogs/index";
    }

    //to save another dog
    @GetMapping("/dogs/save")
    public String save(){
        //save method works for saving and updating
        Dogs dogToSave = new Dogs();
        dogToSave.setAge(4);
        dogToSave.setName("good boy");
        dogToSave.setResideState("TX");
        dogsDao.save(dogToSave);
        return "redirect:/dogs";
    }


//    convert to json in the console in browser
//    fetch(window.location.href).then(res =>res.json()).then(dogs => document.write(dogs.map(dogs =>'<h3>${dogs.name}</h3>').join('')));
}
