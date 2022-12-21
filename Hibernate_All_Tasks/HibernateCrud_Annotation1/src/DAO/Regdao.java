package DAO;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import VO.Regvo;

public class Regdao {

	public void insert(Regvo v)
	{
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.save(v);
			
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
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("from Regvo");
			
			 ls = q.list();
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls;
	}
	
	public List edit(Regvo v)
	{
		List ls = new ArrayList();
		
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("from Regvo where id="+v.getRegid());
			ls = q.list();
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls;
	}
	public void update(Regvo v)
	{
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.update(v);
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void delete(Regvo v)
	{
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.delete(v);
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
