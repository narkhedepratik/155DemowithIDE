package com.cjc.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.main.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

 public	List<User> findAllByUserName(String userName);

}
