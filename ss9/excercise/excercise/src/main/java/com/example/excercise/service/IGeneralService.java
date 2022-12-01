package com.example.excercise.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();
    Optional<T> findById(Integer id);
}
