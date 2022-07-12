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
 * Servlet implementation class Save3
 */
@WebServlet("/Save3")
public class Save3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter p = response.getWriter();
	
		HttpSession s = request.getSession();
		s.setAttribute("abc","nilay");
		s.getAttribute("abc");
		
		p.write(request.getParameter("fn"));
		p.write(request.getParameter("ln"));
		p.write(request.getParameter("un"));
		p.write(request.getParameter("pw"));
		
	
		String s1=request.getParameter("fn"); 
		String s2=request.getParameter("ln");
		String s3=request.getParameter("un");
		String s4=request.getParameter("pw");

		s.setAttribute("abc0",s1);
		s.setAttribute("abc1",s2);
		s.setAttribute("abc2",s3);
		s.setAttribute("abc3",s4);
		
	response.sendRedirect("login3.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
