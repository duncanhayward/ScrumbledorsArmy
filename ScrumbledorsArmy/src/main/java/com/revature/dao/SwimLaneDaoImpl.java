package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.SwimLane;

@Repository
@Component
public class SwimLaneDaoImpl implements Dao<SwimLane> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Integer insert(SwimLane obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);
  }

  @Override
  public SwimLane getPojoById(SwimLane obj) {
    Session session = sessionFactory.getCurrentSession();
    return (SwimLane) session.get(SwimLane.class, obj.getId());
  }

  @Override
  public List<SwimLane> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(SwimLane.class);
    return (List<SwimLane>) crit.list();
  }

  @Override
  public List<SwimLane> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(SwimLane.class);
    for (Criterion c : restrictions) {
      crit.add(c);
    }
    return (List<SwimLane>) crit.list();
  }

  @Override
  public void update(SwimLane obj) {
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(SwimLane obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
