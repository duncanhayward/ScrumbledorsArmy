package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.Dao;
import com.revature.pojo.User;

@Service(value = "AppService")
@Transactional
public class AppService {

  @Autowired
  private Dao<User> userDao;

  public User getUserById(User user) {
    return userDao.getPojoById(user);
  }
}
