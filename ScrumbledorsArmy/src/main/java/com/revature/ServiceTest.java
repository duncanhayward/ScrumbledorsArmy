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
import com.revature.service.AppService;

public class ServiceTest {
	
	//private static AppServiceImpl service;

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AppService service = (AppService) ac.getBean("AppServiceImpl");
		

		//user service test
		
		User user = new User();
		user.setEmail("dunca@aol.com");
		user.setPassword("1");
		user.setUsername("dunc");
		user.setId(1);
		System.out.println(user);
		user.setId(service.insertUser(user));
		user=service.getUser(user);
		User newUser = new User();
		newUser.setId(1);
		newUser = service.getUser(user);
		System.out.println(newUser);
		user.setEmail("dun@sad.com");
		service.updateUser(user);
		System.out.println(user);
		
		// Board service test
	
		Board board = new Board();
		board.setName("morestuff");
		board.setDescription("aLotofStuff");
		System.out.println(board);
		board.setId(service.insertBoard(board));
		board=service.getBoardById(board);
		board.setDescription("changeStuff");
		service.updateBoard(board);
		System.out.println(board);
		
		//swimlane service test

		SwimLane lane = new SwimLane();
		lane.setBoard(board);
		lane.setName("funnn");
		lane.setOrder(3);
		System.out.println(lane);
		lane.setId(service.insertSwimLane(lane));
		lane=service.getSwimLane(lane);
		lane.setName("morefunnn");
		service.updateSwimLane(lane);
		System.out.println(lane);
		
		//story service test

		
		Story story = new Story();
		story.setSwimLane(lane);
		story.setPoints(200);
		story.setDescription("some much fun");
		story.setStart(new Timestamp(System.currentTimeMillis()));
		story.setEndExpected(new Timestamp(story.getStart().getTime() + (14 * 24 * 60 * 60 * 1000)));
		story.setDone('N');
		System.out.println(story);
		story.setId(service.insertStory(story));
		story=service.getStory(story);
		story.setDescription("weeeeee");
		service.updateStory(story);
		System.out.println(story);
		

		//tast service test
		
		Task task = new Task();
		task.setStory(story);
		task.setDescription("work on project");
		task.setDone('N');
		System.out.println(task);
		task.setId(service.insertTask(task));
		task=service.getTask(task);
		task.setDescription("finished working");
		task.setDone('Y');
		service.updateTask(task);
		System.out.println(task);
		service.deleteTask(task);

		
		//	role service test, though these methods should not be accessible
		//	to scrumbleboard clients as of now, just developers and possibly admin
		
		Role role = new Role();
		role.setRole("i");
		role.setId(-1);
		System.out.println(role);
		role.setId(service.insertRole(role));
		role=service.getRole(role);
		role.setRole("stop");
		service.updateRole(role);
		System.out.println(role);
		
		//burn down chart service test
		
		BoardChart bdChart = new BoardChart();
		bdChart.setBoard(board);
		bdChart.setStart(new Timestamp(System.currentTimeMillis()));
		bdChart.setEnd(new Timestamp(bdChart.getStart().getTime() + (14 * 24 * 60 * 60 * 1000)));
		bdChart.setName("Testing a Burn Down Chart");
		System.out.println(bdChart);
		bdChart.setId(service.insertBdChart(bdChart));
		bdChart=service.getBdChart(bdChart);
		bdChart.setName("done testing bdChart");
		service.updateBdChart(bdChart);
		System.out.println(bdChart);
		service.deleteBdChart(bdChart);
		
		//board role service test
		
		BoardRole boardRole = new BoardRole();
		BoardRoleId boardRoleId = new BoardRoleId();
		boardRoleId.setBoard(board);
		boardRoleId.setUser(user);
		boardRole.setR_id(role);
		boardRole.setBrId(boardRoleId);
		System.out.println(boardRole);
		service.insertBoardRole(boardRole);
		boardRole=service.getBoardRole(boardRole);
		
		//get admin role
		Role adminRole = new Role();
		adminRole.setId(1);
		adminRole = service.getRole(adminRole);
		boardRole.setR_id(adminRole);
		service.updateBoardRole(boardRole);
		System.out.println(boardRole);
		service.deleteBoardRole(boardRole);
		service.deleteUser(user);
		User boardUser = new User();
		boardUser.setId(1);
		Board brb = new Board();
		brb.setId(board.getId());
		
		BoardRole testBR = new BoardRole();
		testBR.setBrId(new BoardRoleId(boardUser, brb));
		
		//delete all created records
		service.deleteBoardRole(boardRole);
		service.deleteUser(user);
		service.deleteTask(task);
		service.deleteStory(story);
		service.deleteSwimLane(lane);
		service.deleteBoard(board);
		service.deleteRole(role);
		
		System.out.println("Service Test Finished");
	}
}
