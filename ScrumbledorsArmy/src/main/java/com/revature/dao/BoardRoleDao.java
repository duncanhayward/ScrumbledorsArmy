package com.revature.dao;

import com.revature.pojo.Board;
import com.revature.pojo.BoardRole;
import com.revature.pojo.Role;
import com.revature.pojo.User;

public interface BoardRoleDao extends Dao<BoardRole> {

  public BoardRole getPojoByUserId(User obj);

  public BoardRole getPojoByBoardId(Board obj);

  public BoardRole getPojoByRoleId(Role obj);
}
