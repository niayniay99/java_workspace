package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Regdao;
import VO.Regvo;

/**
 * Servlet implementation class Regco
 */
@WebServlet("/Regco")
public class Regco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regco() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String flag=request.getParameter("flag");

		if(flag.equals("insert"))
		{
			insert(request,response);
			response.sendRedirect("1.jsp");
		}
		
		if(flag.equals("search"))
		{
			search(request,response);
			response.sendRedirect("Search1.jsp");
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
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fn = request.getParameter("fn");
		String ln = request.getParameter("ln");
		
		Regvo v = new Regvo();
		v.setFirstname(fn);
		v.setLastname(ln);
		
		Regdao d = new Regdao();
		d.insert(v);
 	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Regdao d = new Regdao();
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
		
		Regdao d = new Regdao();
		List ls = d.edit(v);
		System.out.println(ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
		
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String fn =(String)request.getParameter("fn");
		String ln =(String)request.getParameter("ln");
		
		Regvo v = new Regvo();
		v.setRegid(id);
		v.setFirstname(fn);
		v.setLastname(ln);
		
		Regdao d = new Regdao();
		d.update(v);
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		Regvo v = new Regvo();
		v.setRegid(id);
		
		Regdao d = new Regdao();
		d.delete(v);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
