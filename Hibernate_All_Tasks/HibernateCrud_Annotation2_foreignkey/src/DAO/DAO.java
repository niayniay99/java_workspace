package DAO;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import VO.Logvo;
import VO.Regvo;

public class DAO {

	public void insertreg(Regvo rv)
	{
		SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(rv);
		
		transaction.commit();
		session.close();
		
	}
	public void insertlog(Logvo lv)
	{
		SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(lv);
		
		transaction.commit();
		session.close();
		
	}
	
	public List search()
	{
		List ls = new ArrayList();
	try {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from Regvo");
		
		ls = q.list();
		
		transaction.commit();
		
		session.close();
		}
	catch (Exception e) {
		// TODO: handle exception
		}
		return ls;	
	}
	public void delete(Regvo d)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.delete(d);

			transaction.commit();
			
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public List edit(Regvo v)
	{
		List ls = new ArrayList();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query q =session.createQuery("from Regvo where id='"+v.getRegid()+"'");
			
			ls = q.list();
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls;
	}
	public void updatelog(Logvo l)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.update(l);
			
			transaction.commit();
			
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void updatereg(Regvo v)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.update(v);
			
			transaction.commit();
			
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
