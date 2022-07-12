package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;


import VO.Regvo;

public class Regdao {

	public void insert(Regvo v)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
			Statement s10 = c.createStatement();
			s10.executeUpdate("insert into mvc1(FirstName,LastName) values('"+v.getFn()+"','"+v.getLn()+"')");
			c.close();
			s10.close();
			} 
		catch (Exception e) {
			e.printStackTrace();
	}

	}
	
	public List search()
	{
		List ls = new ArrayList();
		int id=0;
		String fn="";
		String ln="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
			Statement s1 = c.createStatement();
			ResultSet rs = s1.executeQuery("SELECT * FROM mvc1");
			while(rs.next())
			{
				Regvo v2 = new Regvo();
			 
				id = rs.getInt("id");
				fn = rs.getString("FirstName");
				ln = rs.getString("LastName");
			 				
				v2.setId(id);
				v2.setFn(fn);
				v2.setLn(ln);
				
				ls.add(v2);
			
			}
			s1.close();
			c.close();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return ls;
	}

	public void delete(Regvo v6)
	{
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
			Statement st = c.createStatement();
			st.executeUpdate("delete from mvc1 where id="+v6.getId());
			st.close();
			c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public List edit(Regvo v5)
	{
			List ls = new ArrayList();
			int id=0;
			String fn="";
			String ln="";
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
				Statement s1 = c.createStatement();
				ResultSet rs = s1.executeQuery("SELECT * FROM mvc1 WHERE id="+v5.getId());
				while(rs.next())
				{
					
					 id = rs.getInt("id");
					 fn = rs.getString("FirstName");
					 ln = rs.getString("LastName");
					 
				
					 
					Regvo v1 = new Regvo();
					v1.setId(id);
					v1.setFn(fn);
					v1.setLn(ln);
					
					ls.add(v1);
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
			return ls;
	}
	public void update(Regvo v5)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
			Statement s10 = c.createStatement();
			s10.executeUpdate("update mvc1 set FirstName='"+v5.getFn()+"',LastName='"+v5.getLn()+"' where id='"+v5.getId()+"'");
			c.close();
			s10.close();
			} 
		catch (Exception e) {
			e.printStackTrace();
	}

	}


}
