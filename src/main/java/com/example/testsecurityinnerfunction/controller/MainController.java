package com.example.testsecurityinnerfunction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @GetMapping("/testfilterbefore1")
    public String before1() {

        return "forward:/testfilterafter";
    }

    @GetMapping("/testfilterbefore2")
    public String before2() {

        return "redirect:/testfilterafter";
    }

    @GetMapping("/testfilterafter")
    @ResponseBody
    public String after() {

        return "hihihi";
    }
}
