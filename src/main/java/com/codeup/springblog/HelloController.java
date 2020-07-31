package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {


//  in the browser, localhost:8080/hello, will show the string "hello from spring"
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    //  in the browser, localhost:8080/bye, will show the string "goodbye from spring"
//    @GetMapping("/bye")
//    @ResponseBody
//    public String bye(){
//        return "Goodbye from Spring...";
//    }

    //  in the browser, localhost:8080/hello/<value>, the value will show what you type
    //  for example if localhost:8080/hello/augustine will show "hello augustine" in the browser
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }


    //  this is a longer version of @getmapping
    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + " from a request mapping!";
    }

    @GetMapping("/book/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id, String name){
        //get this id and connect to my db to get book information
        //return view
        return "Viewing book " + id + ".";
    }

}
