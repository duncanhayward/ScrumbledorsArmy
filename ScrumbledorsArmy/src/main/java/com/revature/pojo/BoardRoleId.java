package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class BoardRoleId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2251900798381911473L;

	@ManyToOne
	@JoinColumn(name="U_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name="B_ID")
	private Board board;

	public BoardRoleId() {
		super();
	}

	public BoardRoleId(User user, Board board) {
		super();
		this.user = user;
		this.board = board;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "BoardRoleId [user=" + user + ", board=" + board + "]";
	}

}
