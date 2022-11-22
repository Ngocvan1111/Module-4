package com.codegym.service;

import com.codegym.model.EmailBox;

import java.util.List;

public interface IEmailBoxService {
    List<EmailBox> findAllEmailBox();
    List<String> findAllLanguages();
    List<Integer> findAllPageSize();
    boolean delete(int id);
}
