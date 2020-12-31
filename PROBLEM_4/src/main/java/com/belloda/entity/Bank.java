package com.belloda.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "BANCO")
public class Bank {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "DIRECCION")
    private String address;


    @Column(name = "FECHA_REGISTRO")
    private Date register;

    @OneToMany(cascade = CascadeType.ALL)
    private List < BranchOffice > branchOffices = new ArrayList < BranchOffice > ();

public Bank(){

}

    public Bank(String name, String address, Date register) {
        
        this.name = name;
        this.address = address;
        this.register = register;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public List<BranchOffice> getBranchOffices() {
        return branchOffices;
    }

    public void setBranchOffices(List<BranchOffice> branchOffices) {
        this.branchOffices = branchOffices;
    }

   


    

}
