package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.Dao;
import com.revature.pojo.Board;
import com.revature.pojo.User;

@Service(value = "AppService")
@Transactional
public class AppService {

  @Autowired
  private Dao<User> userDao;
  @Autowired
  private Dao<Board> boardDao;

  public User getUserById(User user) {
    return userDao.getPojoById(user);
  }

  public Board getBoardById(Board board) {
    return boardDao.getPojoById(board);
  }

  public Set<Board> getAllBoards() {
    return boardDao.getAllPojos();
  }
}
