package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

   @RequestMapping(path= "/add/{num1}/and/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2){
       return (num1 + num2);
   }

   @RequestMapping(path= "/subtract/{num1}/from/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int num1, @PathVariable int num2){
       return (num1 - num2);
   }

   @GetMapping("/multiple/{num1}/and/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1, @PathVariable int num2){
       return (num1 * num2);
   }

   @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public int divide(@PathVariable int num1, @PathVariable int num2){
       return (num1 / num2);
   }



}
