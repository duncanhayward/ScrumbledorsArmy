package com.revature;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.pojo.Board;
import com.revature.service.AppService;

public class Driver {

  public static void main(String[] args) {
    System.out.println("Test");

    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    AppService service = (AppService) ac.getBean("AppService");

/*    User user = new User();
    user.setId(21);
    user = service.getUserById(user);

    System.out.println(user);*/

    Set<Board> boards = service.getAllBoards();

    System.out.println(boards);
  }

}
