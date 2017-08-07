package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Role;

@Repository
public class RoleDaoImpl implements Dao<Role> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Integer insert(Role obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);
  }

  @Override
  public Role getPojoById(Role obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Role) session.get(Role.class, obj.getId());
  }

  @Override
  public List<Role> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Role.class);
    return (List<Role>) crit.list();
  }

  @Override
  public List<Role> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Role.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    return (List<Role>) crit.list();
  }

  @Override
  public void update(Role obj) {
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(Role obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
