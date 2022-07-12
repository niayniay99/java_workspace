package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class all7
 */
@WebServlet("/all7")
public class all7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public all7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag =request.getParameter("flag");
		if(flag.equals("insert"))
		{
			insert(request,response);
			p.write("inserted data successfully");
		}
		if(flag.equals("search"))
		{
			search(request,response);
		}
		if(flag.equals("delete"))
		{
			delete(request,response);
		}
		if (flag.equals("edit")) {
			edit(request, response);
		}

		if (flag.equals("update")) {
			update(request, response);
			search(request, response);
		}


		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		p.write("");
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fn =request.getParameter("fn");
		String ln =request.getParameter("ln");
		String un =request.getParameter("un");
		String pw =request.getParameter("pw");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
		Statement s10 =c.createStatement();
		s10.executeUpdate("insert into all7(FirstName,LastName,UserName,PassWord) values('"+fn+"','"+ln+"','"+un+"','"+pw+"')");
		c.close();
		s10.close();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String un1 =request.getParameter("un");
		String pw1=request.getParameter("pw");
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		p.write("");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
			Statement s11 =c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM all7 WHERE UserName='"+un1+"' AND PassWord='"+pw1+"'");
			while(rs.next())
			{
				int id = rs.getInt("id");
				String fn = rs.getString("FirstName");
				String ln = rs.getString("LastName");
				String un = rs.getString("UserName");
				String pw = rs.getString("PassWord");
		
				p.write("<tr>");
				p.write("<td>");
				p.write(id);
				p.write("</td>");
				p.write("<td>");
				p.write(fn);
				p.write("</td>");
				p.write("<td>");
				p.write(ln);
				p.write("</td>");
				p.write("<td>");
				p.write(un);
				p.write("</td>");
				p.write("<td>");
				p.write(pw);
				p.write("</td>");
				p.write("<td>");
				p.write("edit");
				p.write("</td>");
				p.write("</tr>");
				}
			}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String un2 =request.getParameter("un");
		String pw2=request.getParameter("pw");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
			Statement st = c.createStatement();
			st.executeUpdate("delete from insert4 where UserName='"+un2+"' AND PassWord='"+pw2+"'");
			st.close();
			c.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
