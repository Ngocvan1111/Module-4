package com.example.excercise.repository;

import com.example.excercise.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookManager extends JpaRepository<Contract,Integer> {
}
