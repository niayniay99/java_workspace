package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search6
 */
@WebServlet("/Search6")
public class Search6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		p.write("<table border='1px'>");
		p.write("<tr><td>ID</td><td>FirstName</td><td>LastName</td><td>UserName</td><td>Password</td></tr>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from insert4");
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
				p.write("<a href='Edit6?id="+id+"'>Edit</a>");
				p.write("</td>");
				p.write("<td>");
				p.write("<a href='Delete6?id="+id+"'>Delete</a>");
				p.write("</td>");
				p.write("</tr>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		p.write("</table>");
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
