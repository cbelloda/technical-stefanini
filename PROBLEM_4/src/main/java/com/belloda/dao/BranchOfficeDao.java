package com.belloda.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.belloda.entity.Bank;
import com.belloda.entity.BranchOffice;
import com.belloda.util.HibernateUtil;


public class BranchOfficeDao {

    public boolean save(BranchOffice branchOffice){

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(branchOffice);
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

    public BranchOffice findById(int id){

		Transaction transaction = null;
		BranchOffice branchOffice = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			branchOffice = session.get(BranchOffice.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return branchOffice;
    }
    
}
