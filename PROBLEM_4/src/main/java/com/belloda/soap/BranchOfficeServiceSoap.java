package com.belloda.soap;

import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface  BranchOfficeServiceSoap {
    @XmlJavaTypeAdapter(BranchOfficeMapAdapter.class)
    public Map<Integer, BranchOffice> getBranch(int bank);   
    
}
