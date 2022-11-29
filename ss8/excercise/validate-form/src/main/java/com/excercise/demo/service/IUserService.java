package com.excercise.demo.service;

import com.excercise.demo.model.User;

import java.util.List;

public interface IUserService<T> {
List<User> findAll();
void save(User user);
}
