package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Regdao;
import vo.Logvo;
import vo.Regvo;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String flag =request.getParameter("flag");
		
		if(flag.equals("insert"))
		{
		insert(request,response);
		response.sendRedirect("register1.jsp");
		}	
		if(flag.equals("search"))
		{
			search(request,response);
			response.sendRedirect("search1.jsp");
		}
		if(flag.equals("edit"))
		{
			edit(request,response);
			response.sendRedirect("edit1.jsp");
		}
		if(flag.equals("update"))
		{
			update(request,response);
			response.sendRedirect("search1.jsp");
		}
		if(flag.equals("delete"))
		{
			delete(request,response);
			response.sendRedirect("search1.jsp");
		}
	}
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstname=request.getParameter("fn");
		String lastname=request.getParameter("ln");
		String username=request.getParameter("un");
		String password=request.getParameter("pw");
		
		Logvo logvo = new Logvo();
		logvo.setUsername(username);
		logvo.setPassword(password);
		
		Regdao regdao = new Regdao();
		regdao.insertlogin(logvo);
		
		
		Regvo regvo = new Regvo();
		regvo.setFirstname(firstname);
		regvo.setLastname(lastname);
		regvo.setLogvo(logvo);
		
		Regdao regdao1 = new Regdao();
		regdao1.reginsert(regvo);
		
	}
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Regdao regdao = new Regdao();
		List ls = regdao.search();
		
		System.out.println(ls.size());
		
		HttpSession s =request.getSession();
		s.setAttribute("data",ls);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		Regvo v = new Regvo();
		v.setId(id);
		
		Regdao d = new Regdao();
		d.delete(v);
		}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int i = Integer.parseInt(request.getParameter("id"));
		Regvo v = new Regvo();
		v.setId(i);
		
		Regdao d = new Regdao();
		List ls = d.edit(v);
		
		System.out.println(ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("ed",ls);

	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("un");
		String password = request.getParameter("pw");
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
			
		int regid = Integer.parseInt(request.getParameter("regid"));
		int logid = Integer.parseInt(request.getParameter("logid"));
		
		Logvo l = new Logvo();
		l.setId(logid);
		l.setUsername(username);
		l.setPassword(password);
		
		Regdao regdao = new Regdao();
		regdao.updatelog(l);
		
		Regvo v = new Regvo();
		v.setId(regid);
		v.setFirstname(firstname);
		v.setLastname(lastname);
		v.setLogvo(l);
		
		Regdao regdao1 = new Regdao();
		regdao1.updatereg(v);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
