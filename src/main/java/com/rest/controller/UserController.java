package com.rest.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.persistence.entity.User;
import com.service.UserService;

@RestController
public class UserController {

  @Resource
  private UserService userService;

  @ResponseBody
  @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
  public User getUser(@PathVariable String userName) {
    return userService.getUser(userName);
  }

  @ResponseBody
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public String postUser(@RequestBody User user) {
    userService.save(user);
    return "Posted User";
  }
}
