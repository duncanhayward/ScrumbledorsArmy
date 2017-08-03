package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Log;

@Repository
public class LogDaoImpl implements Dao<Log> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Integer insert(Log obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);
  }

  @Override
  public Log getPojoById(Log obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Log) session.get(Log.class, obj.getId());
  }

  @Override
  public List<Log> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Log.class);
    return (List<Log>) crit.list();
  }

  @Override
  public List<Log> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Log.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    return (List<Log>) crit.list();
  }

  @Override
  public void update(Log obj) {
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(Log obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
