package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.Dao;
import com.revature.pojo.Board;
import com.revature.pojo.BoardChart;
import com.revature.pojo.BoardRole;
import com.revature.pojo.Role;
import com.revature.pojo.Story;
import com.revature.pojo.SwimLane;
import com.revature.pojo.Task;
import com.revature.pojo.User;

@Service(value = "AppServiceImpl")
@Transactional
public class AppServiceImpl implements AppService {

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

	@Override
	public User getUser(User user) {
		System.out.println("User in IMPL ->" + user);
		return userDao.getPojoById(user);
	}

	@Override
	public Board getBoardById(Board board) {
	  System.out.println("Board in IMPL ->" + board);
		return boardDao.getPojoById(board);
	}

	@Override
	public User authenticateUser(User user) {
		System.out.println("auth in IMPL" + user);
		List<Criterion> restrict = new ArrayList<>();
		restrict.add(Restrictions.and(Restrictions.ilike("username", user.getUsername()),
				Restrictions.ilike("password", user.getPassword())));

		ArrayList<User> users = (ArrayList<User>) userDao.getAllPojos(restrict);

		if (!users.isEmpty()) {
			System.out.println(user);
			System.out.println(userDao);
			System.out.println("Validation Successfull");
			System.out.println(users.get(0));
			return users.get(0);
		}
		System.out.println("Failed!!!!!");
		return null;
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public Integer insertUser(User user) {
		return userDao.insert(user);
	}

	@Override
	public boolean validRegistration(User user) {
		if (user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
			return false;
		}
		return true;

	}

	@Override
	public List<Board> getAllBoards() {
		return boardDao.getAllPojos();
	}

	@Override
	public Integer insertRole(Role role) {
		return roleDao.insert(role);
	}

	@Override
	public Integer insertBoardRole(BoardRole boardRole) {
		return boardRoleDao.insert(boardRole);

	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public Integer insertTask(Task task) {
		return taskDao.insert(task);
	}

	@Override
	public Integer insertStory(Story story) {
		return storyDao.insert(story);
	}

	@Override
	public Integer insertBoard(Board board) {
		return boardDao.insert(board);
	}

	@Override
	public Integer insertSwimLane(SwimLane lane) {
		return swimLaneDao.insert(lane);
	}

	@Override
	public Integer insertBdChart(BoardChart bdChart) {
		return bdChartDao.insert(bdChart);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.update(board);
	}

	@Override
	public void updateBoardRole(BoardRole boardRole) {
		boardRoleDao.update(boardRole);
	}

	@Override
	public void updateRole(Role role) {
		roleDao.update(role);
	}

	@Override
	public void updateSwimLane(SwimLane lane) {
		swimLaneDao.update(lane);
	}

	@Override
	public void updateStory(Story story) {
		storyDao.update(story);
	}

	@Override
	public void updateTask(Task task) {
		taskDao.update(task);
	}

	@Override
	public void updateBdChart(BoardChart bdChat) {
		bdChartDao.update(bdChat);
	}

	@Override
	public void deleteBoard(Board board) {
		boardDao.delete(board);
	}

	@Override
	public void deleteBoardRole(BoardRole boardRole) {
		boardRoleDao.delete(boardRole);
	}

	@Override
	public void deleteRole(Role role) {
		roleDao.delete(role);
	}

	@Override
	public void deleteSwimLane(SwimLane lane) {
		swimLaneDao.delete(lane);
	}

	@Override
	public void deleteStory(Story story) {
		storyDao.delete(story);
	}

	@Override
	public void deleteTask(Task task) {
		taskDao.delete(task);
	}

	@Override
	public void deleteBdChart(BoardChart bdChat) {
		bdChartDao.delete(bdChat);
	}

	@Override
	public SwimLane getSwimLane(SwimLane lane) {
		return swimLaneDao.getPojoById(lane);
	}

	@Override
	public Story getStory(Story story) {
		return storyDao.getPojoById(story);
	}

	@Override
	public Task getTask(Task task) {
		return taskDao.getPojoById(task);
	}

	@Override
	public Role getRole(Role role) {
	  System.out.println("Role in IMPL ->" + role);
		return roleDao.getPojoById(role);
	}

	@Override
	public BoardChart getBdChart(BoardChart bdChart) {
		return bdChartDao.getPojoById(bdChart);
	}

	@Override
	public BoardRole getBoardRole(BoardRole bdRole) {
	  System.out.println("BoardRole in IMPL ->" + bdRole);
		return boardRoleDao.getPojoById(bdRole);
	}

}