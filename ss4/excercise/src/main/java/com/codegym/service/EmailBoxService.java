package com.codegym.service;

import com.codegym.Repository.IEmailBoxRepository;
import com.codegym.model.EmailBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailBoxService implements IEmailBoxService {
    @Autowired
    IEmailBoxRepository iEmailBoxRepository;
    @Override
    public List<EmailBox> findAllEmailBox() {
        return iEmailBoxRepository.findAllEmailBox();
    }

    @Override
    public List<String> findAllLanguages() {
        return iEmailBoxRepository.findAllLanguages();
    }

    @Override
    public List<Integer> findAllPageSize() {
        return iEmailBoxRepository.findAllPageSize();
    }

    @Override
    public boolean delete(int id) {
        return iEmailBoxRepository.delete(id);
    }
}
