package com.cjc.main.exception_responce;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.main.entity.BaseResponce;
import com.cjc.main.entity.User;
import com.cjc.main.exception.UserNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler {
	
	   @ExceptionHandler(value=UserNotFoundException.class)
	    public ResponseEntity<BaseResponce<User>> handleUserNotFound()
	    {
		    
		   
		   return new ResponseEntity<BaseResponce<User>>( 
				   new BaseResponce<User>(404, "User Not Found" , new Date(), null),
				   HttpStatus.NOT_FOUND
				   );
		    
	    }
	   
}
