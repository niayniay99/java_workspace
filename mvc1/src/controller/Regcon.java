package controller;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Regdao;
import VO.Regvo;
/**
 * Servlet implementation class Regcon
 */
@WebServlet("/Regcon")
public class Regcon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Regcon() {
        // TODO Auto-generated constructor stub
    }

	/**
	 *  
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());

	String flag =request.getParameter("flag");
	if(flag.equals("search"))
	{
		Search(request,response);
		response.sendRedirect("Search.jsp");
	}
	if(flag.equals("insert"))
	{
		insert(request,response);
	}
	if(flag.equals("delete"))
	{
		delete(request,response);
	}
	if(flag.equals("edit"))
	{
		edit(request,response);
		response.sendRedirect("Edit1.jsp");
	}
	if(flag.equals("update"))
	{
		update(request,response);
	}
	
}
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s=request.getParameter("fn");
		String s1=request.getParameter("ln");
		
		Regvo v = new Regvo();
		v.setFn(s);
		v.setLn(s1);
		
		Regdao d = new Regdao();
		d.insert(v);
	}
	
	public void Search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			Regdao d = new Regdao();
			List ls = d.search();
			System.out.println(ls.size());
			
			HttpSession s = request.getSession();
			s.setAttribute("data",ls);
		}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int s4 =Integer.parseInt(request.getParameter("id"));
		Regvo v6 = new Regvo();
		v6.setId(s4);
		
		Regdao d = new Regdao();
		d.delete(v6);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int s5 =Integer.parseInt(request.getParameter("id"));
		Regvo v5 = new Regvo();
		v5.setId(s5);
		Regdao e = new Regdao();
		List ls = e.edit(v5);
		System.out.println(ls.size());
		
		HttpSession s1 = request.getSession();
		s1.setAttribute("ed",ls);
			
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int i =Integer.parseInt(request.getParameter("id"));
		String s1 =(String)request.getParameter("fn");
		String s2 =(String)request.getParameter("ln");
		
		
		Regvo v6 = new Regvo();
		v6.setId(i);	
		v6.setFn(s1);
		v6.setLn(s2);
		
		Regdao u = new Regdao();
		u.update(v6);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
