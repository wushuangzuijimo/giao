package com.woniuxy.service;

import com.woniuxy.domain.User;

import java.util.List;

public interface IUserService {

      List<User> findAll();

      void save(User user);

      void update(User user);

      void delete(Integer uid);

      User findOne(Integer uid);

}
