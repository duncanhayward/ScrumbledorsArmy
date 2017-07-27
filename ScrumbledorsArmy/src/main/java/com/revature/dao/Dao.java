package com.revature.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface Dao<T> {

  // Create
  public void insert(T obj);

  // Read
  public T getPojoById(T obj);

  public List<T> getAllPojos();

  public List<T> getAllPojos(List<Criterion> restrictions);

  // Update
  public void update(T obj);

  // Delete
  public void delete(T obj);
}
