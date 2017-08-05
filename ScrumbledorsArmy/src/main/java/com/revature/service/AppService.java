package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.BoardRoleDao;
import com.revature.dao.Dao;
import com.revature.pojo.Board;
import com.revature.pojo.BoardRole;
import com.revature.pojo.Role;
import com.revature.pojo.User;


public interface AppService {

  public User getUserById(User user);

  public Board getBoardById(Board board);

  public List<Board> getAllBoards() ;

  public Integer saveRole(Role role);
  
  public Role getRoleById(Role role);

  public void saveBoardRole(BoardRole boardRole);
  
  public BoardRole getBoardRole(BoardRole br);

User getUser(User user);

User authenticateUser(User user);

void updateUser(User user);

void insertUser(User user);

boolean validRegistration(User user);

  
}

