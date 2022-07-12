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
 * Servlet implementation class Edit6
 */
@WebServlet("/Edit6")
public class Edit6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit6() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/demo1","root","root");
			Statement st = c.createStatement();

			ResultSet rs = st.executeQuery("select* from insert4 where id="+id);

				while(rs.next())
				{
					int id1 = rs.getInt("id");
					String fn = rs.getString("FirstName");
					String ln = rs.getString("LastName");
					String un = rs.getString("UserName");
					String pw = rs.getString("PassWord");

					p.write("<form action='Update6'><table border='1px'><tr><td><input type='hidden' name='id1' value='"+id1+"'></td></tr>");
					p.write("<tr><td>FirstName</td><td><input type='text' name='fn1' value='"+fn+"'></td></tr>");
					p.write("<tr><td>LastName:</td><td><input type='text' name='ln1' value='"+ln+"'></td></tr>");
					p.write("<tr><td>UserName</td><td><input type='text' name='un1' value='"+un+"'></td></tr>");
					p.write("<tr><td>Password:</td><td><input type='text' name='pw1' value='"+pw+"'></td></tr>");
					p.write("<tr><td><td colspan=2 align='center'><input type='submit' value='Update'></td></tr>");
					p.write("</table>");		
					p.write("</form>");

					
		}
		}
				catch (Exception e) {
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
