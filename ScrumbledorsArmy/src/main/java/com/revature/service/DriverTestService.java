package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.BoardRoleDao;
import com.revature.dao.Dao;
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
public class DriverTestService {

	@Autowired
	private Dao<User> userDao;
	@Autowired
	private Dao<Board> boardDao;
	@Autowired
	private Dao<Role> roleDao;
	@Autowired
	private Dao<BoardRole> boardRoleDao;
	@Autowired
	private Dao<SwimLane> swimLaneDao;
	@Autowired
	private Dao<Story> storyDao;
	@Autowired
	private Dao<Task> taskDao;
	@Autowired
	private Dao<BoardChart> bdChartDao;

	public User getUserById(User user) {
		return userDao.getPojoById(user);
	}

	public Board getBoardById(Board board) {
		return boardDao.getPojoById(board);
	}

	public List<Board> getAllBoards() {
		return boardDao.getAllPojos();
	}

	public Integer saveRole(Role role) {
		return roleDao.insert(role);
	}

	public Role getRoleById(Role role) {
		return roleDao.getPojoById(role);
	}

	public void saveBoardRole(BoardRole boardRole) {
		boardRoleDao.insert(boardRole);
	}

	public BoardRole getBoardRole(BoardRole br) {
		return boardRoleDao.getPojoById(br);
	}

	public void insertSwimLane(SwimLane sw) {
		swimLaneDao.insert(sw);
	}

	public SwimLane getSwimLane(SwimLane sw) {
		// TODO Auto-generated method stub
		return swimLaneDao.getPojoById(sw);
	}

	public void insertStory(Story story) {
		// TODO Auto-generated method stub
		storyDao.insert(story);
	}

	public Story getStory(Story story) {
		// TODO Auto-generated method stub
		return storyDao.getPojoById(story);
	}

	public void insertTask(Task task) {
		// TODO Auto-generated method stub
		taskDao.insert(task);
	}
	
	public Task getTask(Task task){
		return taskDao.getPojoById(task);
	}

	public void insertBDChart(BoardChart bdChart) {
		// TODO Auto-generated method stub
		bdChartDao.insert(bdChart);
	}

	public BoardChart getBDChart(BoardChart bdChart) {
		// TODO Auto-generated method stub
		return bdChartDao.getPojoById(bdChart);
	}

}