package dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.Logvo;
import vo.Regvo;

public class Regdao {
	
	public void insertlogin(Logvo logvo)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction =session.beginTransaction();
			
			session.save(logvo);
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void reginsert(Regvo regvo)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction =session.beginTransaction();
			
			session.save(regvo);
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
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("From Regvo");
		
		ls = q.list();
		
		transaction.commit();
		
		session.close();
	} catch (Exception e) {
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
			
			Query q =session.createQuery("from Regvo where id='"+v.getId()+"'");
			
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
