package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "BOARD_ROLE")
public class BoardRole implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3063808587810134479L;
	
	@EmbeddedId
	private BoardRoleId brId;
	
	@ManyToOne
	@JoinColumn(name="R_ID")
	private Role r_id;


	public BoardRole() {
		super();
	}

	public BoardRole(BoardRoleId brId) {
		super();
		this.brId = brId;
	}

	public BoardRole(BoardRoleId brId, Role r_id) {
		super();
		this.brId = brId;
		this.r_id = r_id;
	}

	public BoardRoleId getBrId() {
		return brId;
	}

	public void setBrId(BoardRoleId brId) {
		this.brId = brId;
	}

	public Role getR_id() {
		return r_id;
	}

	public void setR_id(Role r_id) {
		this.r_id = r_id;
	}

	@Override
	public String toString() {
		return "BoardRole [brId=" + brId + ", r_id=" + r_id + "]";
	}
	
//	@ManyToOne
//	@JoinColumn(name="U_ID")
//	private User user;
//
//	@ManyToOne
//	@JoinColumn(name="B_ID")
//	private Board board;
//
//	@ManyToOne
//	@JoinColumn(name="R_ID")
//	private Role role;
//
//	public BoardRole() {
//	}
//
//	public BoardRole(User user, Board board, Role role) {
//		super();
//		this.user = user;
//		this.board = board;
//		this.role = role;
//	}
//
//	@Override
//	public String toString() {
//		return "BoardRole [user=" + user + ", board=" + board + ", role=" + role + "]";
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Board getBoard() {
//		return board;
//	}
//
//	public void setBoard(Board board) {
//		this.board = board;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}

}
