package com.example.demo.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.form.UserRegisterForm;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



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
  if(!model.containsAttribute("userRegisterForm")){
    model.addAttribute("userRegisterFrom", new UserRegisterForm());
  }
  return "adminUserView";
}

@PostMapping("/register")
public String registerUser(RedirectAttributes redirectAttributes,
  @RequestParam("user_name") String userName,
  @RequestParam("password") String password,
  @RequestParam("role_id") int roleId) {    
    try{
      userService.createUser(userName, password, roleId);
      redirectAttributes.addFlashAttribute("successMessage", "ユーザー登録が完了しました");
    }
    catch(IllegalArgumentException e){
      //登録失敗時はエラーを出力する
      redirectAttributes.addFlashAttribute("failureMessage", e.getMessage());
      //再入力用の入力データをビューに渡す
      redirectAttributes.addFlashAttribute("userName", userName);
      redirectAttributes.addFlashAttribute("role_id", roleId);
    }

    return "redirect:/adminuser";
}


}