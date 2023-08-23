package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class testgender {
        @GetMapping("person")
        public String showGender(Model model) {
            model.addAttribute("gender", "female");
            return "person";
        }
    }
