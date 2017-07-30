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

@Repository
@Component
public class BoardDaoImpl implements Dao<Board> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void insert(Board obj) {
    System.out.println("Inserting a Board");
    Session session = sessionFactory.getCurrentSession();
    session.save(obj);
  }

  @Override
  public Board getPojoById(Board obj) {
    System.out.println("Pulling a Board by ID");
    Session session = sessionFactory.getCurrentSession();
    return (Board) session.get(Board.class, obj.getId());
  }

  @Override
  public List<Board> getAllPojos() {
    System.out.println("Getting all Boards");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Board.class);
    List<Board> boards = crit.list();
    return boards;
  }

  @Override
  public List<Board> getAllPojos(List<Criterion> restrictions) {
    System.out.println("Getting all Boards with Criteria");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Board.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    List<Board> boards = crit.list();
    return boards;
  }

  @Override
  public void update(Board obj) {
    System.out.println("Updating a Board");
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(Board obj) {
    System.out.println("Deleting a Board");
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
