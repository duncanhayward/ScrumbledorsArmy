package com.revature.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Board;
import com.revature.pojo.BoardRole;
import com.revature.pojo.BoardRoleId;
import com.revature.pojo.Role;
import com.revature.pojo.User;
import com.revature.service.AppService;

@RestController
public class ShareCtrl {

  @Autowired
  AppService app;

  /**
   * BoardShare object consists of an admin User, a User to share a board with,
   * the Board to share, and the id of the Role for the new User
   * 
   * @param information for sharing
   * @return response code
   */
  @RequestMapping(value = "/share", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<String> shareBoard(@RequestBody BoardShare obj) {

    User adminUser = app.getUser(obj.getAdminUser());
    User sharedUser = app.getUser(obj.getSharedUser());
    Board sharedBoard = app.getBoardById(obj.getSharedBoard());
    Role shareRole = new Role();
    shareRole.setId(obj.getRoleId());
    shareRole = app.getRole(shareRole);

    BoardRole compareBoardRole = new BoardRole(new BoardRoleId(adminUser, sharedBoard));
    compareBoardRole = app.getBoardRole(compareBoardRole);

    if (compareBoardRole.getR_id().getRole().equals("Admin")) {
      BoardRole shareBoardRole = new BoardRole(new BoardRoleId(sharedUser, sharedBoard), shareRole);
      if (app.getBoardRole(shareBoardRole) == null) {
        app.insertBoardRole(shareBoardRole);
      } else {
        return new ResponseEntity<String>("Shared User already has a Role for this Board", HttpStatus.NOT_ACCEPTABLE);
      }
      return new ResponseEntity<String>("Shared User now has Board Role: " + shareBoardRole.getR_id().getRole(),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<String>("Admin User does not have Admin Role for this Board",
          HttpStatus.NOT_ACCEPTABLE);
    }
  }
}

class BoardShare implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -2034355999746765812L;

  private User adminUser;
  private User sharedUser;
  private Board sharedBoard;
  private int roleId;

  public BoardShare() {
  }

  public BoardShare(User adminUser, User sharedUser, Board sharedBoard, int roleId) {
    super();
    this.adminUser = adminUser;
    this.sharedUser = sharedUser;
    this.sharedBoard = sharedBoard;
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "BoardShare [adminUser=" + adminUser + ", sharedUser=" + sharedUser + ", sharedBoard=" + sharedBoard
        + ", roleId=" + roleId + "]";
  }

  public User getAdminUser() {
    return adminUser;
  }

  public void setAdminUser(User adminUser) {
    this.adminUser = adminUser;
  }

  public User getSharedUser() {
    return sharedUser;
  }

  public void setSharedUser(User sharedUser) {
    this.sharedUser = sharedUser;
  }

  public Board getSharedBoard() {
    return sharedBoard;
  }

  public void setSharedBoard(Board sharedBoard) {
    this.sharedBoard = sharedBoard;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

}