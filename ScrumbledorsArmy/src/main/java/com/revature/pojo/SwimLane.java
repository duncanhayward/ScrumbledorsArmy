package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "SWIM_LANE")
public class SwimLane implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -8833805833751660619L;

  @EmbeddedId
  @Column(name = "SL_ID")
  private int id;
  @Column(name = "B_ID")
  private Board board;
  @Column(name = "SL_NAME")
  private String name;
  @Column(name = "SL_ORDER")
  private int order;

  public SwimLane() {
  }

  public SwimLane(int id, Board board, String name, int order) {
    super();
    this.id = id;
    this.board = board;
    this.name = name;
    this.order = order;
  }

  @Override
  public String toString() {
    return "SwimLane [id=" + id + ", board=" + board + ", name=" + name + ", order=" + order + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

}
