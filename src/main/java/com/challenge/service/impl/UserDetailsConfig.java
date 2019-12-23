package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsConfig implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user = repository.findByEmail(email);
    if (!user.isPresent()) throw new UsernameNotFoundException("Not Found");

    return user.get();
  }}