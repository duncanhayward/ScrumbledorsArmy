package com.revature.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Board;
import com.revature.pojo.BoardRole;
import com.revature.pojo.BoardRoleId;
import com.revature.pojo.Role;
import com.revature.pojo.User;
import com.revature.service.AppService;

@RestController
public class AddBoardCtrl {

		@Autowired
		AppService app;
		
		@RequestMapping(value="/addBoard", method=RequestMethod.POST)
		public ResponseEntity<Integer> addBoard(@RequestBody BoardRolePost boardRP ){
			System.out.println("Inserting Board into DB");
			
			Integer boardID = app.insertBoard(boardRP.getBoard());
			
			if (boardID != null) {
				BoardRole br = new BoardRole();
				User user = new User();
				user.setId(boardRP.getUserid());
				user = app.getUser(user);
				boardRP.getBoard().setId(boardID);
				br.setBrId(new BoardRoleId(user, boardRP.getBoard()));
				Role role = new Role();
				role.setId(1);
				br.setR_id(role);
				app.insertBoardRole(br);
				return new ResponseEntity<Integer>(boardID, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Integer>(HttpStatus.NOT_ACCEPTABLE);
			}
			
		}

	}

class BoardRolePost implements Serializable{
	private Board board;
	private int userid;
	
	public BoardRolePost(){}
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
