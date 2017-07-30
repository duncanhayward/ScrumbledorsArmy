package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.pojo.User;
import com.revature.service.AppService;

public class Driver {

  public static void main(String[] args) {
    System.out.println("Test");

    ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    AppService service = (AppService) ac.getBean("AppService");

    User user = new User();
    user.setId(1);
    user = service.getUserById(user);

    System.out.println(user);
  }

}
