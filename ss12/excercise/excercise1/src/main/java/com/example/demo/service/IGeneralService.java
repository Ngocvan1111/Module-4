package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(Integer id);
    void save(T t);
    void remove(Integer id);
    Page<Blog> findByTitle(String title, Pageable pageable);
}
