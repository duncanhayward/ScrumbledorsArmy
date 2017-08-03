package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOARD_ROLE")
public class BoardRole implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3063808587810134479L;

  @EmbeddedId
  private BoardRoleId brId;

  @ManyToOne
  @JoinColumn(name = "R_ID")
  private Role r_id;

  public BoardRole() {
    super();
  }

  public BoardRole(BoardRoleId brId) {
    super();
    this.brId = brId;
  }

  public BoardRole(BoardRoleId brId, Role r_id) {
    super();
    this.brId = brId;
    this.r_id = r_id;
  }

  public BoardRoleId getBrId() {
    return brId;
  }

  public void setBrId(BoardRoleId brId) {
    this.brId = brId;
  }

  public Role getR_id() {
    return r_id;
  }

  public void setR_id(Role r_id) {
    this.r_id = r_id;
  }

  @Override
  public String toString() {
    return "BoardRole [brId=" + brId + ", r_id=" + r_id + "]";
  }

}
