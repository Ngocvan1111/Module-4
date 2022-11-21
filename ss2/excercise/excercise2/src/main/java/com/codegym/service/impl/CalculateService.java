package com.codegym.service.impl;

import com.codegym.service.ICalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService  {

    @Override
    public Double calculate(double first_number,double second_number,String operation) {
        switch (operation){
            case "Addition(+)":
                return first_number+second_number;
            case "Subtraction(-)":
                return first_number-second_number;
            case "Multiplication(X)":
                return first_number*second_number;
            case "Division(/)":
                return first_number/second_number;
            default:
                return null;



        }
    }

}
