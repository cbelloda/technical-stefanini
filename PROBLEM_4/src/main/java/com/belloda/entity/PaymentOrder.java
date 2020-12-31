package com.belloda.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDENPAGO")
public class PaymentOrder {    

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name="MONTO")
    private double amount;
    @Column(name="MONEDA")
    private String currency;
    @Column(name="ESTADO")
    private String state;    
    @Column(name="FECHA_PAGO")
    private Date paymentDate;
    @Column(name = "SUCURSAL")
    private int branchOffice;
 

    public PaymentOrder(){
        
    }
   
    public PaymentOrder(double amount, String currency, String state, Date paymentDate,int branchOffice) {
        this.amount = amount;
        this.currency = currency;
        this.state = state;
        this.paymentDate = paymentDate;
        this.branchOffice=branchOffice;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(int branchOffice) {
        this.branchOffice = branchOffice;
    }

    

    

}
