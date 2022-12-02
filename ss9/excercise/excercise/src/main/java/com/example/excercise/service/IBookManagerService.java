package com.example.excercise.service;

import com.example.excercise.model.Contract;

public interface IBookManagerService extends IGeneralService<Contract> {
    void save(Contract contract);
   Contract findByCode(Integer code);

}
