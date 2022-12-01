package com.example.excercise.service;

import com.example.excercise.model.Contract;
import com.example.excercise.repository.IBookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookManagerService implements IBookManagerService{
    @Autowired
    private IBookManager iBookManager;
    @Override
    public List<Contract> findAll() {
        return iBookManager.findAll();
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return iBookManager.findById(id);
    }
}
