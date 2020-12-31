package com.belloda.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUCURSAL")
public class BranchOffice {

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

    @Column(name = "BANCO")
    private int bank;
    
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List < PaymentOrder > paymentOrders = new ArrayList < PaymentOrder > ();
    

    public BranchOffice(){
        
    }
    public BranchOffice( String name, String address, Date register,int bank) {
        
        this.name = name;
        this.address = address;
        this.register = register;
        this.bank=bank;
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


    public List<PaymentOrder> getPaymentOrders() {
        return paymentOrders;
    }

    public void setPaymentOrders(List<PaymentOrder> paymentOrders) {
        this.paymentOrders = paymentOrders;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }



    
}
