package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Statedao;
import VO.Statevo;

/**
 * Servlet implementation class StateController
 */
@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
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
		
		if(flag.equals("statename"))
		{
			addstate(request,response);
			response.sendRedirect("addstate.jsp");
		}
		
		if(flag.equals("viewstatename"))
		{
			viewstate(request,response);
			response.sendRedirect("viewstate.jsp");
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void addstate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sn = request.getParameter("sn");
		Statevo sv = new Statevo();
		sv.setSn(sn);
		
		Statedao sd = new Statedao();
		sd.insertsn(sv);
		
	}
	
	protected void viewstate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Statedao sd = new Statedao();
		List ls = sd.search();
		System.out.println(ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
	}
}
