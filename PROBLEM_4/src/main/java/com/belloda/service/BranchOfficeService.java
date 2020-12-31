package com.belloda.service;

import java.util.Date;

import com.belloda.dao.BranchOfficeDao;
import com.belloda.dto.BranchOfficeDto;
import com.belloda.dto.ResponseError;
import com.belloda.dto.ResponseMaintenance;
import com.belloda.dto.ResponseOk;
import com.belloda.entity.Bank;
import com.belloda.entity.BranchOffice;

public class BranchOfficeService {
    private final BranchOfficeDao branchOfficeDao; 

    public BranchOfficeService(){
        branchOfficeDao = new BranchOfficeDao();
    }

    public ResponseMaintenance save(int bank,BranchOfficeDto branchOfficeDto){

        BranchOffice branchOffice= new BranchOffice(branchOfficeDto.getName(),branchOfficeDto.getAddress(), new Date(), bank);
        return branchOfficeDao.save(branchOffice)?new ResponseOk("Branch office created succesfully",branchOffice):new ResponseError();

    }

    public boolean invalidBranchOffice(int id,int bank){
        BranchOffice branchOffice =branchOfficeDao.findById(id);
        return branchOffice==null || branchOffice.getBank()!=bank;
    }

    public BranchOffice getBranch(int id){
        return branchOfficeDao.findById(id);
    }

}
