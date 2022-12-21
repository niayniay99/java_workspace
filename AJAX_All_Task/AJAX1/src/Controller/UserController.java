package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;

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
		
		if(flag.equals("viewun"))
		{
			viewuser(request,response);
			response.sendRedirect("viewuserdetail.jsp");
		}
		
		if(flag.equals("checkusernameajax"))
		{
			System.out.println("came to controller");
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
	
	protected void viewuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Userdao u = new Userdao();
		List ls = u.search1();
		System.out.println(ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
	}
	protected void checkuserajax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String un = request.getParameter("un");
		System.out.println("controller: "+un);
		Uservo uv = new Uservo();
		uv.setUsername(un);
		
		Userdao ud = new Userdao();
		List ls = ud.search(uv);
		System.out.println(ls.size());
		
		HttpSession s = request.getSession();
		if(ls.size()!=0){
			s.setAttribute("key", "username allready exit");
		}
		if(ls.size()==0){
			s.setAttribute("key", "username not exit");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
