package com.ssheld.todotoday.service;

import com.ssheld.todotoday.dao.UserDao;
import com.ssheld.todotoday.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Author: Stephen Sheldon 4/12/2019
 */

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public User findByUsername(String username) {
    return userDao.findByUsername(username);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Load user from the database (throw an exception if not found)
    User user = userDao.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found.");
    }
    // Return user object
    return user;
  }
}
