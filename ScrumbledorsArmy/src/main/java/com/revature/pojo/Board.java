package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BOARD")
public class Board implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -4734100175726060405L;

  @EmbeddedId
  @Column(name = "B_ID")
  private int id;
  @Column(name = "B_NAME")
  private String name;
  @Column(name = "B_DESCRIPTION")
  private String description;

  public Board() {
  }

  public Board(int id, String name, String description) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Board [id=" + id + ", name=" + name + ", description=" + description + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
