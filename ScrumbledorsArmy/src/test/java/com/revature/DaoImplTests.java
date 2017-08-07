package com.revature;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.revature.dao.*;

import com.revature.pojo.*;

public class DaoImplTests {

  @Test
  public void testDao() {
    Dao<User> userDao = new UserDaoImpl();
    Dao<Role> roleDao = new RoleDaoImpl();
    Dao<Board> boardDao = new BoardDaoImpl();
    Dao<SwimLane> swimLaneDao = new SwimLaneDaoImpl();
    Dao<Story> storyDao = new StoryDaoImpl();
    Dao<Task> taskDao = new TaskDaoImpl();
    Dao<BoardChart> boardChartDao = new BoardChartDaoImpl();
    Dao<BoardRole> boardRoleDao = new BoardRoleDaoImpl();

    User user = new User(0, "username", "password", "email");
    Role role = new Role(0, "role");
    Board board = new Board(-1, "name", "description");
    SwimLane swimLane = new SwimLane(0, board, "name", 0);
    Story story = new Story(0, swimLane, 0, null, new Timestamp(System.currentTimeMillis()),
        new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 'N');
    Task task = new Task(0, story, null, 'N');
    BoardChart boardChart = new BoardChart(0, board, new Timestamp(System.currentTimeMillis()),
        new Timestamp(System.currentTimeMillis()), "Test Board Chart");
    BoardRole boardRole = new BoardRole(new BoardRoleId(user, board), role);

    boardChartDao.insert(boardChart);
    boardChart = boardChartDao.getPojoById(boardChart);

    List<Criterion> restrictions = new ArrayList<>(Arrays.asList(Restrictions.ilike("BD_NAME", "")));
    boardChartDao.getAllPojos(restrictions);

  }
}
