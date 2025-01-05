package com.example.demo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;

public class UserDetailsImpl implements UserDetails {
    // 管理用フィールド
    private final User user;
    private final Collection<GrantedAuthority> authorities;

    public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities){
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public String getpassword(){
        return user.getPassword();
    }

    
}
