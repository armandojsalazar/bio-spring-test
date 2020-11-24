package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

   @RequestMapping(path= "/add/{num1}/and/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
       return num1 + " + " + num2 + " = " + (num1 + num2);
   }

   @RequestMapping(path= "/subtract/{num1}/and/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
       return num1 + " - " + num2 + " = " + (num1 - num2);
   }

   @RequestMapping(path= "/multiple/{num1}/and/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
       return num1 + " x " + num2 + " = " + (num1 * num2);
   }

   @RequestMapping(path= "/divide/{num1}/and/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
       return num1 + " / " + num2 + " = " + (num1 / num2);
   }



}
