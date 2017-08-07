package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Task;

@Repository
public class TaskDaoImpl implements Dao<Task> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Integer insert(Task obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);

  }

  @Override
  public Task getPojoById(Task obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Task) session.get(Task.class, obj.getId());
  }

  @Override
  public List<Task> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Task.class);
    return (List<Task>) crit.list();
  }

  @Override
  public List<Task> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Task.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    return (List<Task>) crit.list();
  }

  @Override
  public void update(Task obj) {
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);

  }

  @Override
  public void delete(Task obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
