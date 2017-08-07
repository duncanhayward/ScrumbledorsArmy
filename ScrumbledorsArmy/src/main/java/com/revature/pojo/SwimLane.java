package com.revature.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SWIM_LANE")
public class SwimLane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8833805833751660619L;

	//not necessary for save
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "SWIM_LANE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "SL_ID")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "B_ID")
	private Board board;

	@Column(name = "SL_NAME")
	private String name;

	@Column(name = "SL_ORDER")
	private int order;

	//not necessary for save
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "swimLane", orphanRemoval = true)
	private List<Story> storys = new ArrayList<>();

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

	@JsonIgnore
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
	
	public List<Story> getStorys() {
		return storys;
	}

	public void setStorys(List<Story> storys) {
		this.storys = storys;
	}

}
