package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import dao.Regdao;
import vo.Regvo;

/**
 * Servlet implementation class Regcon
 */
@WebServlet("/Regcon")
public class Regcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regcon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
			
		String flag = request.getParameter("flag");
		if(flag.equals("insert"))
		{
			insert(request,response);
		}
		if(flag.equals("search"))
		{
			search(request,response);
			response.sendRedirect("Search1.jsp");
		}
		if(flag.equals("delete"))
		{
			delete(request,response);
			response.sendRedirect("Search1.jsp");
		}
		if(flag.equals("edit"))
		{
			edit(request,response);
			response.sendRedirect("edit1.jsp");
		}
		if(flag.equals("update"))
		{
			update(request,response);
		}
		
	}
		public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			String firstname=request.getParameter("fn");
			String lastname=request.getParameter("ln");
			
			Regvo regvo = new Regvo();
			
			regvo.setFirstname(firstname);
			regvo.setLastname(lastname);
			
			Regdao regdao = new Regdao();
			regdao.insert(regvo);
			
		}

		public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			Regdao d = new Regdao();
			List ls = d.search();
			System.out.println(ls.size());
			
			HttpSession s = request.getSession();
			s.setAttribute("data",ls);
		}
		public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			int i = Integer.parseInt(request.getParameter("id"));
			Regvo v = new Regvo();
			v.setId(i);
			
			Regdao d = new Regdao();
			d.delete(v);
		}
		public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			int i = Integer.parseInt(request.getParameter("id"));
			Regvo v = new Regvo();
			v.setId(i);
			
			Regdao e = new Regdao();
			List ls = e.edit(v);
		
			System.out.println(ls.size());
			
			HttpSession s = request.getSession();
			s.setAttribute("ed",ls);
		}
		public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			int i =Integer.parseInt(request.getParameter("id"));
			String s1 =(String)request.getParameter("fn");
			String s2 =(String)request.getParameter("ln");
		
			Regvo v = new Regvo();
			v.setId(i);
			v.setFirstname(s1);
			v.setLastname(s2);
			
			Regdao u = new Regdao();
			u.update(v);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);		
	}

}
