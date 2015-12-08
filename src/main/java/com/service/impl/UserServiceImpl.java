package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistence.entity.User;
import com.persistence.repository.UserRepository;
import com.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public User getUser(String userName) {
    List<User> list = userRepository.findByUserName(userName);
    if (null != list) {
      return list.get(0);
    }
    return null;
  }

}
