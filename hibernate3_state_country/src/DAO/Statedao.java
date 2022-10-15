package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.Countryvo;
import VO.Statevo;

public class Statedao {


	public void insertstate(Statevo sv)
	{
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(sv);
		
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
			
			Query q = session.createQuery("From Statevo");

			ls = q.list();
			
			transaction.commit();
			
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls;
	}
		
	public List loadstateajax(Statevo sv)
	{
		List ls = new ArrayList();
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("From Statevo where countryid='"+sv.getCountryvo().getId()+"'");

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
