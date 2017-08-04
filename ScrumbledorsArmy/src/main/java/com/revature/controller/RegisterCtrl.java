package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.User;
import com.revature.service.AppService;
import com.revature.service.AppServiceImpl;

@RestController
public class RegisterCtrl {

	@Autowired
	AppService app;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		System.out.println("registering exsisting user");
		app.insertUser(user);
//		if (userReturned != null) {
//			return new ResponseEntity<User>(userReturned, HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<User>(HttpStatus.IM_USED);
//		}

		System.out.println("User="+user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
//    
//    @Autowired
//    AppServiceImpl app;
//    
//    @RequestMapping(value="register", method=RequestMethod.POST)
//    public ResponseEntity<User> insertUser(@RequestBody User user){
//        System.out.println("registered new user");
//        app.insertUser(user);
//        return new ResponseEntity<User>(HttpStatus.OK);
//    }
}