package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Task;

@Repository
@Component
public class TaskDaoImpl implements Dao<Task> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void insert(Task obj) {
    System.out.println("Inserting Task");
    Session session = sessionFactory.getCurrentSession();
    session.save(obj);

  }

  @Override
  public Task getPojoById(Task obj) {
    System.out.println("Getting Task");
    Session session = sessionFactory.getCurrentSession();
    return (Task) session.get(Task.class, obj.getId());
  }

  @Override
  public List<Task> getAllPojos() {
    System.out.println("Getting all tasks");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Task.class);
    List<Task> tasks = crit.list();
    return tasks;
  }

  @Override
  public List<Task> getAllPojos(List<Criterion> restrictions) {
    System.out.println("Getting all Tasks with Criteria");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Task.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    List<Task> tasks = crit.list();
    return tasks;
  }

  @Override
  public void update(Task obj) {
    System.out.println("Updating Task");
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);

  }

  @Override
  public void delete(Task obj) {
    System.out.println("Deleating Task");
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
