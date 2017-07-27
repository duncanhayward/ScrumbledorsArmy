package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table(name = "LOG_TYPE")
public class LogType implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 506836275817479395L;

  @Id
  @Column(name = "LT_ID")
  public int id;
  @Column(name = "LT_TYPE")
  public String type;

  public LogType() {}

  public LogType(int id, String type) {
    super();
    this.id = id;
    this.type = type;
  }

  @Override
  public String toString() {
    return "LogType [id=" + id + ", type=" + type + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
