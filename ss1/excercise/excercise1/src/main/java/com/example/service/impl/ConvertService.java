package com.example.service.impl;

import com.example.repository.IConvertRepository;
import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {

    @Override
    public double vndToUsd(double vnd) {
        return vnd*22000;
    }

    @Override
    public double usdToVnd(double usd) {
        return usd/22000;
    }
}
