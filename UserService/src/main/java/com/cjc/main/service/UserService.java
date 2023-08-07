package com.cjc.main.service;

import java.util.List;

import com.cjc.main.entity.User;
import com.cjc.main.exception.UserNotFoundException;

public interface UserService {

 public	User saveUserDetails(User user);

public Iterable<User> getAllUsers(int pageNumber);

public User updateUserDetails(int userId, User user);

public void deleteUserDetails(int userId);

public List<User> findUsersByName(String userName)throws UserNotFoundException;

}
