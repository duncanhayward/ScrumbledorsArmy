package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pojo.BoardRole;

@Repository
public class BoardRoleDaoImpl implements Dao<BoardRole> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Integer insert(BoardRole obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);
  }

  @Override
  public BoardRole getPojoById(BoardRole obj) {
    // TODO Auto-generated method stub
    return (BoardRole) sessionFactory.getCurrentSession().get(BoardRole.class, obj.getBrId());
  }

  @Override
  public List<BoardRole> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(BoardRole.class);
    return (List<BoardRole>) crit.list();
  }

  @Override
  public List<BoardRole> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(BoardRole.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    return (List<BoardRole>) crit.list();
  }

  @Override
  public void update(BoardRole obj) {
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(BoardRole obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
