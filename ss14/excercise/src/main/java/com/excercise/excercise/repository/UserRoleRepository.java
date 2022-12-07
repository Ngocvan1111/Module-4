package com.excercise.excercise.repository;

import com.excercise.excercise.entity.AppUser;
import com.excercise.excercise.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
