package com.revature.dao;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
  public void insert(Story obj) {
    System.out.println("Inserting a Story");
    Session session = sessionFactory.getCurrentSession();
    session.save(obj);
  }

  @Override
  public Story getPojoById(Story obj) {
    System.out.println("Pulling a Story by ID");
    Session session = sessionFactory.getCurrentSession();
    return (Story) session.get(Story.class, obj.getId());
  }

  @Override
  public Set<Story> getAllPojos() {
    System.out.println("Getting all Stories");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Story.class);
    Set<Story> stories = new LinkedHashSet<Story>(crit.list());
    return stories;
  }

  @Override
  public Set<Story> getAllPojos(List<Criterion> restrictions) {
    System.out.println("Getting all Stories with Criteria");
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(Story.class);
    for (Criterion c : restrictions) {

      crit.add(c);

    }
    Set<Story> stories = new LinkedHashSet<Story>(crit.list());
    return stories;
  }

  @Override
  public void update(Story obj) {
    System.out.println("Updating a Story");
    Session session = sessionFactory.getCurrentSession();
    session.update(obj);
  }

  @Override
  public void delete(Story obj) {
    System.out.println("Deleting a Story");
    Session session = sessionFactory.getCurrentSession();
    session.delete(obj);
  }

}
