package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3013798401984886501L;

  @EmbeddedId
  @Column(name = "U_ID")
  private int id;
  @Column(name = "U_USERNAME")
  private String username;
  @Column(name = "U_PASSWORD")
  private String password;
  @Column(name = "U_EMAIL")
  private String email;

  public User() {
  }

  public User(int id, String username, String password, String email) {
    super();
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
