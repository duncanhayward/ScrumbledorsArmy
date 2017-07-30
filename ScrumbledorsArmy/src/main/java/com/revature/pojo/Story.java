package com.revature.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STORY")
public class Story implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 7483865353683469642L;

  @Id
  @SequenceGenerator(name = "seq", sequenceName = "STORY_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  @Column(name = "S_ID")
  private int id;
  @Column(name = "SL_ID")
  private SwimLane swimLane;
  @Column(name = "S_POINTS")
  private int points;
  @Column(name = "S_DESCRIPTION")
  private String description;
  @Column(name = "S_START")
  private Timestamp start;
  @Column(name = "S_END_EXPECTED")
  private Timestamp endExpected;
  @Column(name = "S_END_ACTUAL")
  private Timestamp endActual;
  @Column(name = "S_DONE")
  private String done; // actual type is constrained char treated as boolean

  @OneToMany(mappedBy = "id")
  private List<Task> tasks;

  public Story() {
  }

  public Story(int id, SwimLane swimLane, int points, String description, Timestamp start, Timestamp endExpected,
      Timestamp endActual, String done, List<Task> tasks) {
    super();
    this.id = id;
    this.swimLane = swimLane;
    this.points = points;
    this.description = description;
    this.start = start;
    this.endExpected = endExpected;
    this.endActual = endActual;
    this.done = done;
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "Story [id=" + id + ", swimLane=" + swimLane + ", points=" + points + ", description=" + description
        + ", start=" + start + ", endExpected=" + endExpected + ", endActual=" + endActual + ", done=" + done
        + ", tasks=" + tasks + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public SwimLane getSwimLane() {
    return swimLane;
  }

  public void setSwimLane(SwimLane swimLane) {
    this.swimLane = swimLane;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Timestamp getStart() {
    return start;
  }

  public void setStart(Timestamp start) {
    this.start = start;
  }

  public Timestamp getEndExpected() {
    return endExpected;
  }

  public void setEndExpected(Timestamp endExpected) {
    this.endExpected = endExpected;
  }

  public Timestamp getEndActual() {
    return endActual;
  }

  public void setEndActual(Timestamp endActual) {
    this.endActual = endActual;
  }

  public String getDone() {
    return done;
  }

  public void setDone(String done) {
    this.done = done;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

}
