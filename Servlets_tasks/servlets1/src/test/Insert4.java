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
 *Servlet implementation class Insert4
 */
@WebServlet("/Insert4")
public class Insert4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String s1 =request.getParameter("fn");
		String s2 =request.getParameter("ln");
		String s3 =request.getParameter("un");
		String s4 =request.getParameter("pw");
		PrintWriter p = response.getWriter();
		p.write("data entered successfully");
		p.write(s1);
		
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
	Statement s10 = c.createStatement();
	s10.executeUpdate("insert into insert4(FirstName,LastName,UserName,PassWord) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
	c.close();
	s10.close();
	response.sendRedirect("login4.jsp");
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
