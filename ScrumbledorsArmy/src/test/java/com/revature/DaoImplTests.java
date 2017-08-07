package com.revature;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.*;

import com.revature.pojo.*;

@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class DaoImplTests {

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
  private Dao<BoardChart> boardChartDao;

  @Test
  @Rollback(true)
  public void testDao() {

    User user = new User();
    user.setUsername("username");
    user.setPassword("password");
    user.setEmail("email");
    Role role = new Role(0, "role");
    Board board = new Board();
    board.setName("name");
    board.setDescription("description");
    SwimLane swimLane = new SwimLane();
    swimLane.setBoard(board);
    swimLane.setName("name");
    swimLane.setOrder(0);
    Story story = new Story();
    story.setSwimLane(swimLane);
    story.setDescription("description");
    story.setStart(new Timestamp(System.currentTimeMillis()));
    story.setEndExpected(new Timestamp(System.currentTimeMillis()));
    story.setEndActual(new Timestamp(System.currentTimeMillis()));
    story.setDone('N');
    Task task = new Task();
    task.setStory(story);
    task.setDescription("description");
    task.setDone('N');
    BoardChart boardChart = new BoardChart();
    boardChart.setBoard(board);
    boardChart.setStart(new Timestamp(System.currentTimeMillis()));
    boardChart.setEnd(new Timestamp(System.currentTimeMillis()));
    boardChart.setName("name");
    BoardRole boardRole = new BoardRole(new BoardRoleId(user, board), role);

    assertNotNull(user);
    assertNotNull(role);
    assertNotNull(board);
    assertNotNull(swimLane);
    assertNotNull(story);
    assertNotNull(task);
    assertNotNull(boardChart);
    assertNotNull(boardRole);

    user.setId(userDao.insert(user));
    role.setId(roleDao.insert(role));
    board.setId(boardDao.insert(board));
    swimLane.setId(swimLaneDao.insert(swimLane));
    story.setId(storyDao.insert(story));
    task.setId(taskDao.insert(task));
    boardChart.setId(boardChartDao.insert(boardChart));
    boardRoleDao.insert(boardRole);

    user = userDao.getPojoById(user);
    role = roleDao.getPojoById(role);
    board = boardDao.getPojoById(board);
    swimLane = swimLaneDao.getPojoById(swimLane);
    story = storyDao.getPojoById(story);
    task = taskDao.getPojoById(task);
    boardChart = boardChartDao.getPojoById(boardChart);
    boardRole = boardRoleDao.getPojoById(boardRole);

    assertNotNull(user);
    assertNotNull(role);
    assertNotNull(board);
    assertNotNull(swimLane);
    assertNotNull(story);
    assertNotNull(task);
    assertNotNull(boardChart);
    assertNotNull(boardRole);

    /*List<Criterion> restrictions = new ArrayList<>();
    restrictions.add(Restrictions.ilike("name", "name"));
    List<BoardChart> allCharts = boardChartDao.getAllPojos(restrictions);

    assertNotNull(allCharts);*/

    userDao.update(user);
    roleDao.update(role);
    boardDao.update(board);
    swimLaneDao.update(swimLane);
    storyDao.update(story);
    taskDao.update(task);
    boardChartDao.update(boardChart);
    boardRoleDao.update(boardRole);

    assertNotNull(user);
    assertNotNull(role);
    assertNotNull(board);
    assertNotNull(swimLane);
    assertNotNull(story);
    assertNotNull(task);
    assertNotNull(boardChart);
    assertNotNull(boardRole);

    boardRoleDao.delete(boardRole);
    boardChartDao.delete(boardChart);
    taskDao.delete(task);
    storyDao.delete(story);
    swimLaneDao.delete(swimLane);
    boardDao.delete(board);
    roleDao.delete(role);
    userDao.delete(user);

  }
}
