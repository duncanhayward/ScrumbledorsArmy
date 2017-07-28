package com.revature.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name = "BOARD")
public class Board implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -4734100175726060405L;

  @Id
  @SequenceGenerator(name = "seq", sequenceName = "BOARD_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  @Column(name = "B_ID")
  private int id;
  @Column(name = "B_NAME")
  private String name;
  @Column(name = "B_DESCRIPTION")
  private String description;

  @OneToMany(mappedBy = "id")
  private List<SwimLane> swimLanes;

  public Board() {
  }

  public Board(int id, String name, String description, List<SwimLane> swimLanes) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
    this.swimLanes = swimLanes;
  }

  @Override
  public String toString() {
    return "Board [id=" + id + ", name=" + name + ", description=" + description + ", swimLanes=" + swimLanes + "]";
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

  public List<SwimLane> getSwimLanes() {
    return swimLanes;
  }

  public void setSwimLanes(List<SwimLane> swimLanes) {
    this.swimLanes = swimLanes;
  }

}
