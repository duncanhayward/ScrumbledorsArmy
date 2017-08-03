package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.pojo.Board;
import com.revature.pojo.BoardRole;
import com.revature.pojo.BoardRoleId;
import com.revature.pojo.Role;
import com.revature.pojo.User;
import com.revature.service.AppService;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Test");

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AppService service = (AppService) ac.getBean("AppService");

		User user = new User();
		user.setId(21);
		user = service.getUserById(user);

		System.out.println(user);

		Board board = new Board();
		board.setId(22);
		board = service.getBoardById(board);

		System.out.println(board);

		/*
		 * Role role = new Role(); role.setRole("Admin"); int id =
		 * service.saveRole(role);
		 * 
		 * System.out.println(id);
		 */

		Role newRole = new Role();
		newRole.setId(1);
		newRole = service.getRoleById(newRole);

		System.out.println(newRole);

		BoardRole boardRole = new BoardRole();
		boardRole.setBrId(new BoardRoleId(user, board));
		boardRole.setR_id(newRole);

		System.out.println(boardRole);

		service.saveBoardRole(boardRole);

		BoardRole newBoardRole = new BoardRole();
		newBoardRole.setBrId(new BoardRoleId());
		newBoardRole.getBrId().setUser(user);
		newBoardRole.getBrId().setBoard(board);

		System.out.println(newBoardRole);

		newBoardRole = service.getBoardRole(newBoardRole);

		System.out.println(newBoardRole);
	}

}