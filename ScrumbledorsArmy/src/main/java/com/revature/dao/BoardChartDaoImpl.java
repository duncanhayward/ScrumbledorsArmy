package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.BoardChart;

@Repository
public class BoardChartDaoImpl implements Dao<BoardChart> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Integer insert(BoardChart obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);
  }

  @Override
  public BoardChart getPojoById(BoardChart obj) {
    Session session = sessionFactory.getCurrentSession();
    return (BoardChart) session.get(BoardChart.class, obj.getId());
  }

  @Override
  public void update(BoardChart obj) {
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(BoardChart obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);

  }

  @Override
  public List<BoardChart> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(BoardChart.class);
    return (List<BoardChart>) crit.list();
  }

  @Override
  public List<BoardChart> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(BoardChart.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    return (List<BoardChart>) crit.list();
  }

}
