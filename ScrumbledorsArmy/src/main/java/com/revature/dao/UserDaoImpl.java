package com.revature.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.User;

@Repository
@Component
public class UserDaoImpl implements Dao<User> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void insert(User obj) {
    System.out.println("Inserting User");
    Session session = sessionFactory.getCurrentSession();
    session.save(obj);
  }

  @Override
  public User getPojoById(User obj) {
    System.out.println("Getting User");
//    obj.setId(21);
    Session session = sessionFactory.getCurrentSession();
    return (User) session.get(User.class, obj.getId());
  }

  @Override
  public Set<User> getAllPojos() {
    System.out.println("Getting all Users");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(User.class);
    Set<User> list = new TreeSet<User>(crit.list());
    return list;
  }

  @Override
  public Set<User> getAllPojos(List<Criterion> restrictions) {
    System.out.println("Getting all Users with Criteria");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(User.class);
    for (Criterion c : restrictions) {
      crit.add(c);
    }
    Set<User> list = new TreeSet<User>(crit.list());
    return list;
  }

  @Override
  public void update(User obj) {
    System.out.println("Updating User");
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(User obj) {
    System.out.println("Deleting User");
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

//@Override
//public User getPojoByUsername(User obj) {
//    System.out.println("Getting User");
//    Session session = sessionFactory.getCurrentSession();
//    return (User) session.get(User.class, obj.getUsername());
//}

}
