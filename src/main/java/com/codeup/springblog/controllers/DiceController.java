package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String question() {
        return "dice";
    }

    //walkthrough code
//    @GetMapping("/roll-dice/{num}")
//    public String roll(@PathVariable int num, Model model) {
//        int randomNum = (int) (Math.random() * 6) + 1;
//        String message;
//        if (randomNum == num) {
//            message = "you guessed correctly";
//        } else {
//            message = "wrong try again";
//        }
//        model.addAttribute("num", num);
//        model.addAttribute("randomNum", randomNum);
//        model.addAttribute("message", message);
//        return "diceresult";
//    }

    @RequestMapping(path = "/roll-dice/{num}", method = RequestMethod.GET)
    public String roll(@PathVariable int num, Model model){
        int randomNum = (int) Math.floor(Math.random() * 6) + 1;
        Boolean isTrue = (num == randomNum);
        model.addAttribute("isTrue", isTrue);
        model.addAttribute("roll", randomNum);
        return "diceresult";
    }

}
