package com.revature;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.pojo.Board;
import com.revature.pojo.BoardChart;
import com.revature.pojo.BoardRole;
import com.revature.pojo.BoardRoleId;
import com.revature.pojo.Role;
import com.revature.pojo.Story;
import com.revature.pojo.SwimLane;
import com.revature.pojo.Task;
import com.revature.pojo.User;
import com.revature.service.DriverTestService;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Test");

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		DriverTestService service = (DriverTestService) ac.getBean("DriverAppService");

		User user = new User();
		user.setId(21); // hard coded
		user = service.getUserById(user);

		System.out.println(user);
		System.out.println(user.getBoardRoles());

		Board board = new Board();
		board.setId(22); // hard coded
		board = service.getBoardById(board);

		System.out.println(board);
		System.out.println(board.getBdCharts());

		/*
		 * Role role = new Role(); role.setRole("Admin"); int id =
		 * service.saveRole(role);
		 * 
		 * System.out.println(id);
		 */

		Role newRole = new Role();
		newRole.setId(1); // hard coded
		newRole = service.getRoleById(newRole);

		System.out.println(newRole);

		BoardRole boardRole = new BoardRole();
		boardRole.setBrId(new BoardRoleId(user, board));
		boardRole.setR_id(newRole);

		System.out.println(boardRole);

		// service.saveBoardRole(boardRole);

		BoardRole newBoardRole = new BoardRole();
		newBoardRole.setBrId(new BoardRoleId());
		newBoardRole.getBrId().setUser(user);
		newBoardRole.getBrId().setBoard(board);

		System.out.println(newBoardRole);

		newBoardRole = service.getBoardRole(newBoardRole);

		System.out.println(newBoardRole);

		SwimLane sw = new SwimLane();
		sw.setBoard(board);
		sw.setName("To Do");
		sw.setOrder(0);

		// service.insertSwimLane(sw);

		sw.setId(2050); // hard coded

		sw = service.getSwimLane(sw);

		board = service.getBoardById(board);

		System.out.println("SwimLanes: " + board.getSwimLanes());

		Story story = new Story();
		story.setDescription("Test the Story Dao");
		story.setStart(new Timestamp(System.currentTimeMillis()));
		story.setEndExpected(new Timestamp(story.getStart().getTime() + (14 * 24 * 60 * 60 * 1000)));
		story.setSwimLane(sw);
		story.setPoints(1000000);

		// service.insertStory(story);

		story.setId(50); // hard coded
		story = service.getStory(story);

		// finish testing

		Task task = new Task();
		task.setDone('N');
		task.setStory(story);
		task.setDescription("testing tasks");

		// service.insertTask(task);
		task.setId(150);
		task = service.getTask(task);
		System.out.println(task);

		story = service.getStory(story);
		System.out.println(story);
		System.out.println(story.getTasks());

		BoardChart bdChart = new BoardChart();
		bdChart.setBoard(board);
		bdChart.setStart(new Timestamp(System.currentTimeMillis()));
		bdChart.setEnd(new Timestamp(bdChart.getStart().getTime() + (14 * 24 * 60 * 60 * 1000)));
		bdChart.setName("Test Burn Down Chart");

		// service.insertBDChart(bdChart);
		bdChart.setId(50);
		bdChart = service.getBDChart(bdChart);
		System.out.println(bdChart);

	}

}