package com.excercise.demo.service;

import com.excercise.demo.model.User;
import com.excercise.demo.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {

    @Autowired
    IUser iUser;

    @Override
    public List findAll() {
        return iUser.findAll();
    }
    @Override
    public void save(User user) {
            iUser.save(user);
    }
}
