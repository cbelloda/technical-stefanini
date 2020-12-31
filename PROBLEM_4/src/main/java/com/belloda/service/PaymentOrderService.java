package com.belloda.service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.belloda.dao.PaymentOrderDao;
import com.belloda.dto.Currency;
import com.belloda.dto.PaymentOrderDto;
import com.belloda.dto.ResponseError;
import com.belloda.dto.ResponseMaintenance;
import com.belloda.dto.ResponseOk;
import com.belloda.entity.BranchOffice;
import com.belloda.entity.PaymentOrder;

public class PaymentOrderService {

    private final PaymentOrderDao paymentOrderDao;

    public PaymentOrderService(){
        paymentOrderDao= new PaymentOrderDao();
    }

    public ResponseMaintenance save(int branchOffice,PaymentOrderDto paymentOrderDto){
        PaymentOrder paymentOrder = new PaymentOrder(paymentOrderDto.getAmount(), 
        paymentOrderDto.getCurrency().toString(), paymentOrderDto.getState().toString(),new Date(),branchOffice);

        return paymentOrderDao.save(paymentOrder)?new ResponseOk("Payment order created succesfully",paymentOrder):new ResponseError();
        
    }

    public List<PaymentOrder> getPayments(int branchOffice,Currency currency){
        return paymentOrderDao.findByBranch(branchOffice).stream().filter(order->order.getCurrency().equals(currency.toString()))
        .collect(Collectors.toList());    
    }
    
}
