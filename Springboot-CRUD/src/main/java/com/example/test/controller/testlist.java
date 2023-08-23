package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class testlist {
    @GetMapping("list")
    public String listNumber (Model model) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i<= 10; i++) {
            list.add("This is ArrayList" + i);
        }
        model.addAttribute("list", list);
        return "list";
    }
}