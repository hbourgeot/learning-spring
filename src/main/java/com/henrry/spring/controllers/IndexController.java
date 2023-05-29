package com.henrry.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class IndexController {
  
  @GetMapping(value = "/")
  public String index(Model model) {
    model.addAttribute("titulo", "Soy el titulo");
    model.addAttribute("saludo", "Hola henrry!");
    return "index";
  }

  @PostMapping(value="//hola")
  public String hola() {
    return "index";
  }
  
}
