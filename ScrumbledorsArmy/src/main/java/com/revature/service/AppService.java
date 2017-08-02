package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.Dao;
import com.revature.pojo.Board;
import com.revature.pojo.User;


public interface AppService {

	public User getUser(User user);

    public Board getBoardById(Board board);

    public Set<Board> getAllBoards();
    
    public User authenticateUser(User user);
    
    public void updateUser(User user);
    
    public void insertUser(User user);
    
    public boolean validRegistration(User user);

}
