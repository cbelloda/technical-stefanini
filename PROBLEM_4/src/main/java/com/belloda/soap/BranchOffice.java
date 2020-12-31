package com.belloda.soap;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(BranchOfficeAdapter.class)
public interface BranchOffice {
    
    String getName();
    String getAddress();
}
