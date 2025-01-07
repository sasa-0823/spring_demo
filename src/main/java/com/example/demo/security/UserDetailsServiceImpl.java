package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    try{
      // 送信されたユーザー名と一致するユーザー情報をテーブルから取得
      User user = userRepository.findByUserName(username).get(0);
      //ロールを取得
      String userRoleName = switch(user.getRoleId()){
        case 1 -> "ROLE_GENERAL";
        case 2 -> "ROLE_ADMIN";
        default -> "ROLE_GENERAL";
      };

    //ロールをリスト用オブジェクトに
    Collection<GrantedAuthority> authorities = new ArrayList<>();

    // ユーザーのロール名をリストに追加
    authorities.add(new SimpleGrantedAuthority(userRoleName));

    //ロールを元にuserDetailsImplを生成
    return new UserDetailsImpl(user, authorities);
    }catch(Exception e){
      throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
    }
  }
}
