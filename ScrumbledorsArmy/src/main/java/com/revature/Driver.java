package com.revature;

import java.util.List;

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

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AppService service = (AppService) ac.getBean("AppService");

		User user = new User();
		user.setId(1);
		user = service.getUserById(user);

		Board board = new Board();
		board.setId(1);
		board = service.getBoardById(board);

		Role newRole = new Role();
		newRole.setId(50);
		newRole = service.getRoleById(newRole);

		List<User> users;
		users = service.getAllUsers();
		System.out.println(users);

	}

}