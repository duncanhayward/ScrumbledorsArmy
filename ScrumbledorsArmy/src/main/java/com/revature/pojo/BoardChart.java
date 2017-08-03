package com.revature.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BD_CHART")
public class BoardChart implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 676631759009182870L;

  @Id
  @SequenceGenerator(name = "seq", sequenceName = "CHART_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  @Column(name = "BD_ID")
  private int id;

  @ManyToOne
  @JoinColumn(name = "B_ID")
  private Board board;

  @Column(name = "BD_START")
  private Timestamp start;

  @Column(name = "BD_END")
  private Timestamp end;

  @Column(name = "BD_NAME")
  private String name;

  public BoardChart() {
  }

  public BoardChart(int id, Board board, Timestamp start, Timestamp end, String name) {
    super();
    this.id = id;
    this.board = board;
    this.start = start;
    this.end = end;
    this.name = name;
  }

  @Override
  public String toString() {
    return "BoardChart [id=" + id + ", board=" + board + ", start=" + start + ", end=" + end + ", name=" + name + "]";
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

  public Timestamp getStart() {
    return start;
  }

  public void setStart(Timestamp start) {
    this.start = start;
  }

  public Timestamp getEnd() {
    return end;
  }

  public void setEnd(Timestamp end) {
    this.end = end;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
