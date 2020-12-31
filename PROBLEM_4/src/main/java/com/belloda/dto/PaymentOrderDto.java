package com.belloda.dto;

import java.io.Serializable;
import java.util.Date;

public class PaymentOrderDto implements Serializable {
 
    private static final long serialVersionUID = 1L;   
    Currency currency;
    StateOrder state;
    double amount;
    Date paymentDate;

    public PaymentOrderDto(){

    }
    public PaymentOrderDto(Currency currency, StateOrder state, double amount, Date paymentDate) {
        this.currency = currency;
        this.state = state;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public StateOrder getState() {
        return state;
    }

    public void setState(StateOrder state) {
        this.state = state;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    

    
}
