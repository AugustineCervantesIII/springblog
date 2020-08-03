package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String question(){
        return "dice";
    }

    @RequestMapping(path = "/roll-dice/{num}", method = RequestMethod.GET)
    public String roll(@PathVariable int num, Model model){
        int randomNum = (int) Math.floor(Math.random() * 6);
        Boolean isTrue = (num == randomNum);
        model.addAttribute("isTrue", isTrue);
        model.addAttribute("roll", randomNum);
        return "diceresult";
    }

}
