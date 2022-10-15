package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.RegVO;

public class RegDAO {
	
	public void insert(RegVO regVO)
		{
			try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					
					Session session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.save(regVO);
					
					transaction.commit();
					
					session.close();
				}
			catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}

}
