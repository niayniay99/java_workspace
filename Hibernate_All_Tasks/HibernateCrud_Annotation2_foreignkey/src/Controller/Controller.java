package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import VO.Logvo;
import VO.Regvo;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String flag = request.getParameter("flag");
		
		if(flag.equals("insert"))
		{
			insert(request,response);
			response.sendRedirect("Reg.jsp");
		}
		
		if(flag.equals("search"))
		{
			search(request,response);
			response.sendRedirect("search1.jsp");
		}
		
		if(flag.equals("edit"))
		{
			edit(request,response);
			response.sendRedirect("Update1.jsp");
		}
		
		if(flag.equals("update"))
		{
			update(request,response);
			response.sendRedirect("Search1.jsp");
		}
		
		if(flag.equals("delete"))
		{
			delete(request,response);
			response.sendRedirect("Search1.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn = request.getParameter("fn");
		String ln = request.getParameter("ln");
		String un = request.getParameter("un");
		String pw = request.getParameter("pw");
		
		Regvo rv = new Regvo();
		rv.setFn(fn);
		rv.setLn(ln);
		
		
		Logvo lv = new Logvo();
		lv.setUn(un);
		lv.setPw(pw);
		
		DAO d = new DAO();
		d.insertreg(rv);
		d.insertlog(lv);
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DAO d = new DAO();
		List ls = d.search();
		System.out.println(ls.size());

		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
		
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id =Integer.parseInt(request.getParameter("id"));
		
		Regvo v = new Regvo();
		v.setRegid(id);
		
		DAO d = new DAO();
		List ls = d.edit(v);
		System.out.println(ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
		
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("un");
		String password = request.getParameter("pw");
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
			
		int regid = Integer.parseInt(request.getParameter("regid"));
		int logid = Integer.parseInt(request.getParameter("logid"));
		
		Logvo l = new Logvo();
		l.setLogid(logid);
		l.setUn(username);
		l.setPw(password);
		
		DAO d = new DAO();
		d.updatelog(l);
		
		Regvo v = new Regvo();
		v.setRegid(regid);
		v.setFn(firstname);
		v.setLn(lastname);
		v.setLvo(l);
		
		DAO d1 = new DAO();
		d1.updatereg(v);

		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		Regvo v = new Regvo();
		v.setRegid(id);
		
		DAO d = new DAO();
		d.delete(v);
	}

}
