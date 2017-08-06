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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TASK")
public class Task implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5786947412418542399L;

	@Id
	@SequenceGenerator(name = "seq", sequenceName = "TASK_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "T_ID")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "S_ID")
	private Story story;

	@Column(name = "T_DESCRIPTION")
	private String description;

	@Column(name = "T_DONE")
	private char done; // actual type is constrained char treated as boolean

	public Task() {
	}

	public Task(int id, Story story, String description, char done) {
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

	@JsonIgnore
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

	public char getDone() {
		return done;
	}

	public void setDone(char done) {
		this.done = done;
	}

}
