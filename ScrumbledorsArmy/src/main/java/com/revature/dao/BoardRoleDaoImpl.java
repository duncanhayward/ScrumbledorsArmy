package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Board;
import com.revature.pojo.BoardRole;
import com.revature.pojo.Role;
import com.revature.pojo.User;

@Repository
@Component
public class BoardRoleDaoImpl implements BoardRoleDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @Deprecated
  public Integer insert(BoardRole obj) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void insertPojo(BoardRole obj) {
    Session session = sessionFactory.getCurrentSession();
    session.save(obj);
  }

  @Override
  @Deprecated
  public BoardRole getPojoById(BoardRole obj) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BoardRole getPojoByUserId(User obj) {
    Session session = sessionFactory.getCurrentSession();
    return (BoardRole) session.get(BoardRole.class, obj.getId());
  }

  @Override
  public BoardRole getPojoByBoardId(Board obj) {
    Session session = sessionFactory.getCurrentSession();
    return (BoardRole) session.get(BoardRole.class, obj.getId());
  }

  @Override
  public BoardRole getPojoByRoleId(Role obj) {
    Session session = sessionFactory.getCurrentSession();
    return (BoardRole) session.get(BoardRole.class, obj.getId());
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
