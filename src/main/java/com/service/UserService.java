package com.service;

import com.persistence.entity.User;

public interface UserService {

  public void save(User user);

  public User getUser(String userName);
}
