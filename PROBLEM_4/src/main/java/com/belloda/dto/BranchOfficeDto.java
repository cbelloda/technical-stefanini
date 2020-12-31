package com.belloda.dto;

import java.io.Serializable;

public class BranchOfficeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String address;

    public BranchOfficeDto(){
        
    }
    public BranchOfficeDto(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
