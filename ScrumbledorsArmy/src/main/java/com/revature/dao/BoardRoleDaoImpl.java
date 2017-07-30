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
  public void insert(BoardRole obj) {
    System.out.println("Inserting a Board Role");
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
    System.out.println("Pulling a Board Role by User ID");
    Session session = sessionFactory.getCurrentSession();
    return (BoardRole) session.get(BoardRole.class, obj.getId());
  }

  @Override
  public BoardRole getPojoByBoardId(Board obj) {
    System.out.println("Pulling a Board Role by Board ID");
    Session session = sessionFactory.getCurrentSession();
    return (BoardRole) session.get(BoardRole.class, obj.getId());
  }

  @Override
  public BoardRole getPojoByRoleId(Role obj) {
    System.out.println("Pulling a Board Role by Role ID");
    Session session = sessionFactory.getCurrentSession();
    return (BoardRole) session.get(BoardRole.class, obj.getId());
  }

  @Override
  public List<BoardRole> getAllPojos() {
    System.out.println("Getting all Board Roles");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(BoardRole.class);
    List<BoardRole> roles = crit.list();
    return roles;
  }

  @Override
  public List<BoardRole> getAllPojos(List<Criterion> restrictions) {
    System.out.println("Getting all Board Roles with Criteria");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(BoardRole.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    List<BoardRole> roles = crit.list();
    return roles;
  }

  @Override
  public void update(BoardRole obj) {
    System.out.println("Updating a Board Role");
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(BoardRole obj) {
    System.out.println("Deleting a Board Role");
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
