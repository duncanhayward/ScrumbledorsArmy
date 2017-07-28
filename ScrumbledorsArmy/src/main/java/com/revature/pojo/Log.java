package com.revature.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOG")
public class Log implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 2762951739501458964L;

  @Id
  @SequenceGenerator(name = "seq", sequenceName = "LOG_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  @Column(name = "L_ID")
  private int id;
  @Column(name = "U_ID")
  private User user;
  @Column(name = "L_DESC")
  private String description;
  @Column(name = "L_TIMESTAMP")
  private Timestamp timestamp;
  @Column(name = "LT_ID")
  private LogType logType;

  public Log() {
  }

  public Log(int id, User user, String description, Timestamp timestamp, LogType logType) {
    super();
    this.id = id;
    this.user = user;
    this.description = description;
    this.timestamp = timestamp;
    this.logType = logType;
  }

  @Override
  public String toString() {
    return "Log [id=" + id + ", user=" + user + ", description=" + description + ", timestamp=" + timestamp
        + ", logType=" + logType + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public LogType getLogType() {
    return logType;
  }

  public void setLogType(LogType logType) {
    this.logType = logType;
  }

}
