package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Citydao;
import DAO.Statedao;
import VO.Cityvo;
import VO.Statevo;

/**
 * Servlet implementation class CityController
 */
@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
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
		if(flag.equals("addcity"))
		{
			addcity(request,response);
			response.sendRedirect("addcity.jsp");
		}
		if(flag.equals("insertcity"))
		{
			insertcity(request,response);
			response.sendRedirect("addcity.jsp");
		}
		
		if(flag.equals("viewcity"))
		{
			viewcity(request,response);
			response.sendRedirect("Cityview.jsp");
		}
		
		if(flag.equals("loadcityAJAX"))
		{
			loadcityajax(request,response);
			response.sendRedirect("cityjson.jsp");
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void addcity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Statedao sv = new Statedao();
		List ls = sv.search();
		System.out.println(ls.size());
		
		HttpSession cs = request.getSession();
		cs.setAttribute("data",ls);
	}
	
	protected void insertcity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int stateid =Integer.parseInt(request.getParameter("stateId"));
		String cn =(String)request.getParameter("city");
		
		Statevo sv = new Statevo();
		sv.setStateid(stateid);
		
		Cityvo cv = new Cityvo();
		cv.setCityname(cn);
		cv.setStatevo(sv);
		
		Citydao cd = new Citydao();
		cd.insertcity(cv);
		
	}
	
	protected void viewcity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Citydao c = new Citydao();
		List ls = c.search();
		System.out.println("No of City : "+ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
	}
	
	protected void loadcityajax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int sid =Integer.parseInt(request.getParameter("stateid"));
		
		Statevo sv = new Statevo();
		sv.setStateid(sid);
		
		Cityvo cv = new Cityvo();
		cv.setStatevo(sv);
		
		Citydao c = new Citydao();
		List ls = c.loadcityajax(cv);
		
		System.out.println("No. of City: "+ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
