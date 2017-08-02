package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.Dao;
import com.revature.pojo.Board;
import com.revature.pojo.User;

@Service(value = "AppServiceImpl")
@Transactional
public class AppServiceImpl implements AppService{
    

      @Autowired
      private static Dao<User> userDao;
     
      @Autowired
      private static Dao<Board> boardDao;
      
      @Autowired
      private static AppService app;
      
      @Override
      public  User getUser(User user) {
        return userDao.getPojoById(user);
    }
    @Override
    public Board getBoardById(Board board) {
        return boardDao.getPojoById(board);
    }
    @Override
    public Set<Board> getAllBoards() {
        return boardDao.getAllPojos();
    }
    @Override
    public User authenticateUser(User user) {
          app.getUser(user);

          if(user.getUsername() != null && user.getPassword() != null){
                System.out.println(user);
                System.out.println(userDao);
                return user;    
            }
        return null;
    }
    
    @Override
    public void updateUser(User user) {
         userDao.update(user);
    }
    
    @Override
    public void insertUser(User user) {
        userDao.insert(user);
    }
    
    @Override
    public boolean validRegistration(User user) {
        if(user.getUsername()==null || user.getEmail()==null || user.getPassword()==null ){
            return false;
        }return true;
        
    }
      
    

}