package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table(name = "TASK")
public class Task implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 5786947412418542399L;

  @Id
  @Column(name = "T_ID")
  private int id;
  @Column(name = "S_ID")
  private Story story;
  @Column(name = "T_DESCRIPTION")
  private String description;
  @Column(name = "T_DONE")
  private String done; // actual type is constrained char treated as boolean

  public Task() {
  }

  public Task(int id, Story story, String description, String done) {
    super();
    this.id = id;
    this.story = story;
    this.description = description;
    this.done = done;
  }

  @Override
  public String toString() {
    return "Task [id=" + id + ", story=" + story + ", description=" + description + ", done=" + done + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Story getStory() {
    return story;
  }

  public void setStory(Story story) {
    this.story = story;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDone() {
    return done;
  }

  public void setDone(String done) {
    this.done = done;
  }

}
