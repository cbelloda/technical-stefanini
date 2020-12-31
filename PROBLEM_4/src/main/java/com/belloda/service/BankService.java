package com.belloda.service;

import java.util.Date;

import com.belloda.dao.BankDao;
import com.belloda.dto.BankDto;
import com.belloda.dto.ResponseError;
import com.belloda.dto.ResponseMaintenance;
import com.belloda.dto.ResponseOk;
import com.belloda.entity.Bank;

public class BankService {
    private final BankDao bankDao;
    public BankService(BankDao bankDao){
        this.bankDao=bankDao;
    }
    public boolean invalidBank(int id){
        return bankDao.findById(id)==null;
    }
    public ResponseMaintenance save(BankDto bankInput){
        Bank bank= new Bank( bankInput.getName(), bankInput.getAddress(),new Date());
        return bankDao.save(bank)? new ResponseOk("bank created succesfully",bank):new ResponseError();
    }
}
