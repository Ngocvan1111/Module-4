package com.excercise.excercise.service;

import com.excercise.excercise.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);

}
