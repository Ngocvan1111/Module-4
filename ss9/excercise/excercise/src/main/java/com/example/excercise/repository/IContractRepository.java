package com.example.excercise.repository;

import com.example.excercise.model.Book;
import com.example.excercise.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Contract findByCode(Integer code);
}
