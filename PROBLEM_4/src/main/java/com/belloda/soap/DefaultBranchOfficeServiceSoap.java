package com.belloda.soap;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.belloda.dao.BranchOfficeDao;

@WebService(endpointInterface = "com.belloda.soap.BranchOfficeServiceSoap")
public class  DefaultBranchOfficeServiceSoap implements  BranchOfficeServiceSoap{
    
    private Map<Integer, BranchOffice> branchesfromBank = new LinkedHashMap<Integer, BranchOffice>();

    
    public Map<Integer, BranchOffice> getBranch(int bank){

        BranchOfficeDao  branchOfficeDao = new BranchOfficeDao();

        List<com.belloda.entity.BranchOffice> branches=  branchOfficeDao.findByBank(bank);
        
        for(com.belloda.entity.BranchOffice branch:branches){
            branchesfromBank.put(branch.getId(),new DefaultBranch(branch.getName(),branch.getAddress()));
        }

        return branchesfromBank;

    }  
    
}
