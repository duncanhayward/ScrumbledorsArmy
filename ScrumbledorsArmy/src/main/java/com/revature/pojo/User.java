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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3013798401984886501L;

	@Id
	@SequenceGenerator(name = "seq", sequenceName = "USERS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "U_ID")
	private int id;
	@Column(name = "U_USERNAME")
	private String username;
	@Column(name = "U_PASSWORD")
	private String password;
	@Column(name = "U_EMAIL")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "brId.user", orphanRemoval = true)
	private List<BoardRole> boardRoles = new ArrayList<>();

	public User() {
	}

	public User(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BoardRole> getBoardRoles() {
		return boardRoles;
	}

	public void setBoardRoles(List<BoardRole> boardRoles) {
		this.boardRoles = boardRoles;
	}
	
}
