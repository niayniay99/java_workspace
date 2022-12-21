package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import VO.Uservo;

public class Userdao {
	
	public void enter(Uservo uv)
	{
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			
			session.save(uv);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List search(Uservo uv)
	{
		List ls = new ArrayList();
		try {
			SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
Transaction transaction = session.beginTransaction();
			
			Query q = session.createQuery("from Userdao where username='"+uv.getUsername()+"'");
			
			 ls = q.list();
			
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return ls;
	
		
		
	}
}
