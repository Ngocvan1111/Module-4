package com.excercise.demo.repository;

import com.excercise.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Integer> {
}
