package com.example.demo.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@Controller
public class AdminUserController {
  private final UserService userService;

  public AdminUserController(UserService userService){
    this.userService = userService;
  } 


@GetMapping("/adminuser")
public String adminUser(Model model){
  List<User> users = userService.getAllUsers();
  model.addAttribute("users", users);
  return "adminUserView";
}

}