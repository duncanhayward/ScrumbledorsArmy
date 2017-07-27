package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3443225460812901410L;

  @EmbeddedId
  @Column(name = "R_ID")
  private int id;
  @Column(name = "R_ROLE")
  private String role;

  public Role() {
  }

  public Role(int id, String role) {
    super();
    this.id = id;
    this.role = role;
  }

  @Override
  public String toString() {
    return "Role [id=" + id + ", role=" + role + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}
