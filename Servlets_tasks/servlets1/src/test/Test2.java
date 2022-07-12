package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/Test2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		System.out.println("Hello");
	
		PrintWriter p = response.getWriter();
		
		p.write("Nilay");
		p.write("<br>");
		p.write("N");
		p.write("<br>");
		p.write("Doshi");
		p.write("<br>");
		
		HttpSession s = request.getSession();
		s.setAttribute("abc","nilay");
		s.getAttribute("abc");
		
		p.write(request.getParameter("fn"));
		p.write(request.getParameter("ln"));
	
		String s1=request.getParameter("fn"); 
		String s2=request.getParameter("ln");

		if(s1.equals("admin") && s2.equals("admin"))
		{
			response.sendRedirect("welcome2.jsp");
		}
		else
		{
			p.write("Enter Correct UserName and Password");
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
