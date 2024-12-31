package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {  //<エンティティ名, 主キーのデータ型>
  List<User> findByUserName(String userName);
}
