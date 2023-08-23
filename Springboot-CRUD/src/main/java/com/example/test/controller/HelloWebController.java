package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWebController {
@GetMapping("/web")
    public String ello(Model model){
        model.addAttribute("hello", "Hello world! by thymeleaf"); //(變數名稱,變數值)
        return"Hello";
    }
}
