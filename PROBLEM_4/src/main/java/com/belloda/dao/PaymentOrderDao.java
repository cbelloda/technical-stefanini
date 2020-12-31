package com.belloda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.belloda.entity.PaymentOrder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.belloda.util.HibernateUtil;


public class PaymentOrderDao {


    public boolean save(PaymentOrder paymentOrder){

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(paymentOrder);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

    }

    public List<PaymentOrder> findByBranch(int branchOffice){
        
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            String hql = "FROM PaymentOrder PO WHERE PO.branchOffice = :branchId";
            Query query = session.createQuery(hql);            
            return query.setParameter("branchId",branchOffice).getResultList();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
}
