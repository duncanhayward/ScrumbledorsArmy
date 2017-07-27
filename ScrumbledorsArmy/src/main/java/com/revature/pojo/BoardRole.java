package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "BOARD_ROLE")
public class BoardRole implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3063808587810134479L;

  @Column(name = "U_ID")
  private User user;
  @Column(name = "B_ID")
  private Board board;
  @Column(name = "R_ID")
  private Role role;

  public BoardRole() {
  }

  public BoardRole(User user, Board board, Role role) {
    super();
    this.user = user;
    this.board = board;
    this.role = role;
  }

  @Override
  public String toString() {
    return "BoardRole [user=" + user + ", board=" + board + ", role=" + role + "]";
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

}
