package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pojo.Board;
import com.revature.pojo.BoardChart;
import com.revature.pojo.BoardRole;
import com.revature.pojo.Role;
import com.revature.pojo.Story;
import com.revature.pojo.SwimLane;
import com.revature.pojo.Task;
import com.revature.pojo.User;

@Service(value = "AppService")
@Transactional
public interface AppService {


	public Board getBoardById(Board board);

	public List<Board> getAllBoards();

	public Integer insertRole(Role role);

	public Integer insertBoardRole(BoardRole boardRole);

	public User getUser(User user);
	
	public SwimLane getSwimLane(SwimLane lane);
	
	public Story getStory(Story story);
	
	public Task getTask(Task task);
	
	public Role getRole(Role role);
	
	public BoardChart getBdChart(BoardChart bdChart);
	
	public BoardRole getBoardRole(BoardRole bdRole);

	public User authenticateUser(User user);

	public void updateUser(User user);

	public Integer insertUser(User user);

	boolean validRegistration(User user);
	
	public void deleteUser(User user);
	
	public Integer insertTask(Task task);
	
	public Integer insertStory(Story story);
	
	public Integer insertBoard(Board board);
	
	public Integer insertSwimLane(SwimLane lane);
	
	public Integer insertBdChart(BoardChart bdChart);
	
	public void updateBoard(Board board);
	
	public void updateBoardRole(BoardRole boardRole);
	
	public void updateRole(Role role);
	
	public void updateSwimLane(SwimLane lane);
	
	public void updateStory(Story story);
	
	public void updateTask(Task task);
	
	public void updateBdChart(BoardChart bdChart);
	
	public void deleteBoard(Board board);
	
	public void deleteBoardRole(BoardRole boardRole);
	
	public void deleteRole(Role role);
	
	public void deleteSwimLane(SwimLane lane);
	
	public void deleteStory(Story story);
	
	public void deleteTask(Task task);
	
	public void deleteBdChart(BoardChart bdChart);
	
}
