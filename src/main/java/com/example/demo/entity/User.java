package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data  //ゲッター、セッターを自動生成
public class User {
  @Id //主キー
  @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto_incrementと同じ意味
  @Column(name = "user_id")
  private Integer userId;
  
  @Column(name = "user_name")
  private String userName;

  @Column(name = "password")
  private String password;

  @Column(name = "role_id")
  private Integer roleId;

}
