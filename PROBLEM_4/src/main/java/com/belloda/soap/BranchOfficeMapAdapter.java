package com.belloda.soap;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BranchOfficeMapAdapter extends XmlAdapter<BranchOfficeMap, Map<Integer, BranchOffice>>{
    
    public BranchOfficeMap marshal(Map<Integer, BranchOffice> boundMap) throws Exception {
        BranchOfficeMap valueMap = new BranchOfficeMap();
        for (Map.Entry<Integer, BranchOffice> boundEntry : boundMap.entrySet()) {
            BranchOfficeMap.BranchOfficeEntry valueEntry = new BranchOfficeMap.BranchOfficeEntry();
            valueEntry.setBranchOffice(boundEntry.getValue());
            valueEntry.setId(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }

    public Map<Integer, BranchOffice> unmarshal(BranchOfficeMap valueMap) throws Exception {
        Map<Integer, BranchOffice> boundMap = new LinkedHashMap<Integer, BranchOffice>();
        for (BranchOfficeMap.BranchOfficeEntry branchOfficeEntry : valueMap.getEntries()) {
            boundMap.put(branchOfficeEntry.getId(), branchOfficeEntry.getBranchOffice());
        }
        return boundMap;
    }

}
