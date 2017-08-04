package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;

@Repository
public class BoardDaoImpl implements Dao<Board> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Integer insert(Board obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);
  }

  @Override
  public Board getPojoById(Board obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Board) session.get(Board.class, obj.getId());
  }

  @Override
  public List<Board> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Board.class);
    return (List<Board>) crit.list();
  }

  @Override
  public List<Board> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Board.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    return (List<Board>) crit.list();
  }

  @Override
  public void update(Board obj) {
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(Board obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
