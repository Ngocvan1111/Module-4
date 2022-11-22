package com.codegym.Repository;

import com.codegym.model.EmailBox;

import java.util.List;

public interface IEmailBoxRepository {
    List<EmailBox> findAllEmailBox();
    List<String> findAllLanguages();
    List<Integer> findAllPageSize();
    boolean delete(int id);
}
