package com.belloda.soap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "BranchOfficeMap")
public class BranchOfficeMap {

    
    private List<BranchOfficeEntry> entries = new ArrayList<BranchOfficeEntry >();

    @XmlElement(nillable = false, name = "entry")
    public List<BranchOfficeEntry> getEntries() {
        return entries;
    }



    @XmlType(name = "BranchOfficeEntry")
    public static class BranchOfficeEntry {
        private Integer id;
        private BranchOffice branchOffice;

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setBranchOffice(BranchOffice branchOffice) {
            this.branchOffice = branchOffice;
        }

        public BranchOffice getBranchOffice() {
            return branchOffice;
        }
    }

}
