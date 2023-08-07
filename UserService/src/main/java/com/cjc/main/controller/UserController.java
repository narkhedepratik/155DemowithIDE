package com.cjc.main.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.entity.BaseResponce;
import com.cjc.main.entity.User;
import com.cjc.main.exception.UserNotFoundException;
import com.cjc.main.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@PostMapping("/createUser")
	public ResponseEntity<BaseResponce<User>> createuser(@RequestBody User user)
	{
		User savedUser=userService.saveUserDetails(user);
		
		return new ResponseEntity<BaseResponce<User>>
		(new BaseResponce<User>(201, "User Created", new Date(), savedUser)  , HttpStatus.CREATED);
	}
   @GetMapping("/users/{pageNumber}")
   public Iterable<User> getUsers(@PathVariable int pageNumber)
   {
	   Iterable<User> users=userService.getAllUsers(pageNumber);
	  return users;
   }
   @PutMapping("/user/{userId}")
   public User updateUser(@PathVariable int userId
		                 ,@RequestBody User user)
   {
	   User u=userService.updateUserDetails(userId,user);
	   return u;
   }
   @DeleteMapping("user/{userId}")
   public void removeUser(@PathVariable int userId)
   {
	     userService.deleteUserDetails(userId);
   }
   @GetMapping("user/{userName}")
   public ResponseEntity<BaseResponce<List<User>>> findUsers(@PathVariable String userName)
		                                                                         throws UserNotFoundException 
   {
	   List<User> searchedUsers;
		searchedUsers = userService.findUsersByName(userName);
		return new ResponseEntity<BaseResponce<List<User>>>
		                                 (
				                          new BaseResponce<List<User>>
				                                                (200,"Serach Result", new Date(),searchedUsers ),
				                         HttpStatus.OK
				                                            );

   }
   

   
}
