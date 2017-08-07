package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojo.Board;
import com.revature.pojo.BoardRole;
import com.revature.pojo.Role;
import com.revature.pojo.User;

public interface BoardRoleDao extends Dao<BoardRole> {

  public void insertPojo(BoardRole obj);
  
  public BoardRole getPojoByUserIdAndBoardId(User user, Board board);

  public ArrayList<BoardRole> getPojoByUserId(User obj);

  public ArrayList<BoardRole> getPojoByBoardId(Board obj);

  public ArrayList<BoardRole> getPojoByRoleId(Role obj);

}
