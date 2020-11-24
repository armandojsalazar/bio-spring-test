package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String dice(){
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String guessedRoll(@PathVariable int n, Model model){
        int random = (int) (Math.random() * ((6 - 1)) + 1);
        boolean correct = (n == random);
        model.addAttribute("correct", correct);
        model.addAttribute("number", n);
        model.addAttribute("randomNumber", random );
        return "/correct-dice-roll";
    }


}
