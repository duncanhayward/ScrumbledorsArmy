package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.pojo.Story;

@Repository
@Component
public class StoryDaoImpl implements Dao<Story> {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Integer insert(Story obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Integer) session.save(obj);
  }

  @Override
  public Story getPojoById(Story obj) {
    Session session = sessionFactory.getCurrentSession();
    return (Story) session.get(Story.class, obj.getId());
  }

  @Override
  public List<Story> getAllPojos() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Story.class);
    return (List<Story>) crit.list();
  }

  @Override
  public List<Story> getAllPojos(List<Criterion> restrictions) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Story.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    return (List<Story>) crit.list();
  }

  @Override
  public void update(Story obj) {
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(Story obj) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
