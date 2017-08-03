package com.revature.pojo;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SWIM_LANE")
public class SwimLane implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -8833805833751660619L;

  @Id
  @SequenceGenerator(name = "seq", sequenceName = "SWIM_LANE_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  @Column(name = "SL_ID")
  private int id;
  
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "B_ID")
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
