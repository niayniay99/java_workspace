package DAO;


import java.io.IOException;
import javax.servlet.annotation.WebServlet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import VO.Countryvo;
import java.util.*;

public class Countrydao {
	
	public void insertcn( Countryvo cn)
	{
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.save(cn);
			
			transaction.commit();
			
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public List search()
	{
		List ls = new ArrayList();
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("From Countryvo");

			ls = q.list();
			
			transaction.commit();
			
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls;
	}
	public List search1()
	{
		List ls = new ArrayList();
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("from Countryvo");
			
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
