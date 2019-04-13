package com.ssheld.todotoday.service;

import com.ssheld.todotoday.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  User findByUsername(String username);
}
