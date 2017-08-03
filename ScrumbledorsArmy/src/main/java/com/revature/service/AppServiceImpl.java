package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
      private  Dao<User> userDao;
     
      @Autowired
      private  Dao<Board> boardDao;
      

      private  AppService app;
      
      @Override
      public  User getUser(User user) {
    	  System.out.println("User in IMPL ->"+ user);
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
    	System.out.println("auth in IMPL"+ user);
    	List<Criterion> restrict = new ArrayList<>();
    	restrict.add(Restrictions.and(Restrictions.ilike("username", user.getUsername()),
    			Restrictions.ilike("password", user.getPassword())));
    	
         ArrayList<User> users= (ArrayList<User>) userDao.getAllPojos(restrict);
         

          if(users.get(0)!= null ){
                System.out.println(user);
                System.out.println(userDao);
                System.out.println("Validation Successfull");
                return users.get(0);    
            }
          System.out.println("Failed!!!!!");
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