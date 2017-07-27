package com.revature.dao;

import java.util.List;

public interface Dao<T> {

  // Create
  public void insert(T obj);

  // Read
  public T getPojoById(T obj);

  public List<T> getAllPojos();

  // Update
  public void update(T obj);

  // Delete
  public void delete(T obj);
}
