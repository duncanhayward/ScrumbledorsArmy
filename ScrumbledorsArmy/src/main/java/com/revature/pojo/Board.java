package com.revature.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
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
	
//	@OneToMany(mappedBy="B_ID", fetch = FetchType.EAGER)
//	@Fetch(value=FetchMode.SELECT)
//	private ArrayList<SwimLane> swimLanes;

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
