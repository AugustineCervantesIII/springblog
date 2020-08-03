package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    //add
    @RequestMapping(path = "add/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int number2){
        return number + " + " + number2 + " = " + (number + number2) + ".";
    }

    //subtract
    @RequestMapping(path = "/subtract/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int number, @PathVariable int number2) {
        return number + " - " + number2 + " = " + (number - number2) + ".";
    }

    //multiply
    @RequestMapping(path = "/multiply/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number, @PathVariable int number2) {
        return number + " * " + number2 + " = " + (number * number2) + ".";
    }

    //divide
    @RequestMapping(path = "/divide/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int number, @PathVariable int number2) {
        return number + " / " + number2 + " = " + (number / number2) + ".";
    }

}