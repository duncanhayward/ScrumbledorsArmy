package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.pojo.User;
import com.revature.service.AppServiceImpl;


public class RegisterCtrl {

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