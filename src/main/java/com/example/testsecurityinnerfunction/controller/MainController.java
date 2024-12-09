package com.example.testsecurityinnerfunction.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@Controller
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String mainPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.logout();
        request.login("username", "password");

        return "aaa";
    }

}
