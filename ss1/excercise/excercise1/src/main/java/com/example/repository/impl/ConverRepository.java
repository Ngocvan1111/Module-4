package com.example.repository.impl;

import com.example.repository.IConvertRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConverRepository implements IConvertRepository {


    @Override
    public double vndToUsd(double vnd) {
        return vnd*22000;
    }

    @Override
    public double usdToVnd(double usd) {
       return usd/22000;
    }
}
