package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthContoroller {
    @GetMapping("/login")
        public String login(){
        return "auth/auth";
    }
}
