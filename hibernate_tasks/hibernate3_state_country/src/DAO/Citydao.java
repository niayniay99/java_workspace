package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.Cityvo;

public class Citydao {

	public void insertcity(Cityvo cv)
	{
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(cv);
		
		transaction.commit();
		session.close();
		
	}
	public List search()
	{
		List ls = new ArrayList();
		
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("From Cityvo");

			ls = q.list();
			
			transaction.commit();
			
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls;

	}

	public List loadcityajax(Cityvo cv)
	{
		List ls = new ArrayList();
		
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("From Cityvo where stateid='"+cv.getStatevo().getStateid()+"'");

			ls = q.list();
			
			transaction.commit();
			
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls;

	}

}
