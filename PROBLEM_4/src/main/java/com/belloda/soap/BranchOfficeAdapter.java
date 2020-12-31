package com.belloda.soap;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BranchOfficeAdapter extends XmlAdapter<DefaultBranch, BranchOffice> {
    public DefaultBranch marshal(BranchOffice branch) throws Exception {
        if (branch instanceof DefaultBranch) {
            return (DefaultBranch) branch;
        }
        return new DefaultBranch(branch.getName(), branch.getAddress());
    }

    public BranchOffice unmarshal(DefaultBranch branch) throws Exception {
        return branch;
    }
}
