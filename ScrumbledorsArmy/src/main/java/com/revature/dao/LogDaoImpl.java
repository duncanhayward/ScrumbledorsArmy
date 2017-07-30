package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Log;

@Repository
@Component
public class LogDaoImpl implements Dao<Log> {
  
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void insert(Log obj) {
    System.out.println("Inserting a Log");
    Session session = sessionFactory.getCurrentSession();
    session.save(obj);
  }

  @Override
  public Log getPojoById(Log obj) {
    System.out.println("Pulling a Story by ID");
    Session session = sessionFactory.getCurrentSession();
    return (Log) session.get(Log.class, obj.getId());
  }

  @Override
  public List<Log> getAllPojos() {
    System.out.println("Getting all Logs");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Log.class);
    List<Log> logs = crit.list();
    return logs;
  }

  @Override
  public List<Log> getAllPojos(List<Criterion> restrictions) {
    System.out.println("Getting all Logs with Criteria");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Log.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    List<Log> logs = crit.list();
    return logs;
  }

  @Override
  public void update(Log obj) {
    System.out.println("Updating a Log");
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(Log obj) {
    System.out.println("Deleting a Log");
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
