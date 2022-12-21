package dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.Regvo;
import java.util.*;
/**
 * Servlet implementation class Regdao
 */
@WebServlet("/Regdao")
public class Regdao 
{
	public void insert(Regvo regvo)
	{
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
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
			e.printStackTrace();

		}
		return ls;
		
		}
	public void delete(Regvo v)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
				session.delete(v);

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
			
			Query q = session.createQuery("from Regvo where id='"+v.getId()+"'");
			
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
