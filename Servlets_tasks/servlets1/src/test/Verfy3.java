package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Verfy3
 */
@WebServlet("/Verfy3")
public class Verfy3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verfy3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession s = request.getSession();

		PrintWriter p = response.getWriter();
	//register details	
//	String s0=(String)s.getAttribute("abc0");
//	String s1=(String)s.getAttribute("abc1");
	String s2=(String)s.getAttribute("abc2");
	String s3=(String)s.getAttribute("abc3");

	//login details
	String s00=request.getParameter("un1");
	String s01=request.getParameter("pw1");

	
	if((s2.equals(s00)) && (s3.equals(s01)))
	{
	response.sendRedirect("welcome3.jsp");
	}
	else
	{
	response.sendRedirect("reg3.jsp");
	}
		p.write(s00);
		p.write(s01);
		p.write(s2);
		p.write(s3);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
