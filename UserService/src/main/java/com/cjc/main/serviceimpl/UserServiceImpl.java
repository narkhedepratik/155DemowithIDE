package com.cjc.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cjc.main.entity.User;
import com.cjc.main.exception.UserNotFoundException;
import com.cjc.main.repo.UserRepository;
import com.cjc.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepository repository;
	@Override
	public User saveUserDetails(User user) {
		
		return repository.save(user);
	}
	@Override
	public Iterable<User> getAllUsers(int pageNumber) {
		
		Sort sort=Sort.by("userName");
		
		Pageable pageable=PageRequest.of(pageNumber, 2,sort);
		
		return repository.findAll(pageable);
	}
	@Override
	public User updateUserDetails(int userId, User user) {
		
		   Optional<User> optinalUser = repository.findById(userId);
		      if(optinalUser.isPresent())
		      {
		    	 User updatedUser = repository.save(user);
		    	 return updatedUser;
		      }
		      else {
		    	  // throw exception
		      }
		      
		return null	;
				
	  }
	@Override
	public void deleteUserDetails(int userId) {
		 Optional<User> optinalUser = repository.findById(userId);
	      if(optinalUser.isPresent())
	      {
	    	  repository.deleteById(userId);
	    	
	      }
	      else {
	    	  // throw exception
	    	  System.out.println("User Not Found In DB..!");
	      }
	}
	@Override
	public List<User> findUsersByName(String userName)throws UserNotFoundException {
		
		   List<User> users=   repository.findAllByUserName(userName);
		
		      if(users.size()!=0)
		      {
		    	 return users;
		      }else {
		        throw new UserNotFoundException("No such user In database with name "+userName); 	  
		      }

	}
	

}
