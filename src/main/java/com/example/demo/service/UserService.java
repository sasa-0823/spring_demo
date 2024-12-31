package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  //依存性の注入
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  //新規ユーザーの登録メソッド
  public void createUser(String userName, String password, int role_id){
    if(userName == null || userName.isEmpty()){
      throw new IllegalArgumentException("ユーザー名を入力してください");
    }
    //重複チェック
    if (!userRepository.findByUserName(userName).isEmpty()){
      throw new IllegalArgumentException("そのユーザー名は利用されています");
    }

    User user = new User();
    user.setUserName(userName);
    user.setPassword(password);
    user.setRoleId(role_id);

    userRepository.save(user);
  }

  public List<User> getAllUsers(){
    return userRepository.findAll();
  }
}
