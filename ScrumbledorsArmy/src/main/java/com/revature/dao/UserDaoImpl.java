package com.revature.dao;

import java.util.List;

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
  public Integer insert(User obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);
  }

  @Override
  public User getPojoById(User obj) {
    Session session = sessionFactory.getCurrentSession();
    return (User) session.get(User.class, obj.getId());
  }

  @Override
  public List<User> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(User.class);
    return (List<User>) crit.list();
  }

  @Override
  public List<User> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(User.class);
    for (Criterion c : restrictions) {
      crit.add(c);
    }
    return (List<User>) crit.list();
  }

  @Override
  public void update(User obj) {

    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(User obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
