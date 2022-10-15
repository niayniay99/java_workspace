package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Userdao;
import VO.Uservo;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String flag =(String)request.getParameter("flag");
	
		if(flag.equals("addusername"))
		{
			adduser(request,response);
			response.sendRedirect("adduserdetail.jsp");
		}
		
		if(flag.equals("checkusernameajax"))
		{
			checkuserajax(request,response);
			response.sendRedirect("userjson.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fn=(String)request.getParameter("fn"); 
		String ln=(String)request.getParameter("ln"); 
		String un=(String)request.getParameter("un"); 
		String pw=(String)request.getParameter("pw"); 
		
		Uservo uv = new Uservo();
		uv.setFirstname(fn);
		uv.setLastname(ln);
		uv.setUsername(un);
		uv.setPassword(pw);
		
		Userdao ud = new Userdao();
		ud.enter(uv);
	}
	
	protected void checkuserajax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String un = (String)request.getParameter("un");
		
		Uservo uv = new Uservo();
		uv.setUsername(un);
		
		Userdao ud = new Userdao();
		List ls = ud.search(uv);
		System.out.println(ls.size());
		
		if(ls.size()>0)
		{	
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
