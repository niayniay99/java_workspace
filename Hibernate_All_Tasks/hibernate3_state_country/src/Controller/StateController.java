package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Countrydao;
import DAO.Statedao;
import VO.Countryvo;
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
		if(flag.equals("adstate"))
		{
			addstat(request,response);
			//response.sendRedirect("addstate.jsp");
		}
		
		if(flag.equals("insertstate"))
		{
			insertstat(request,response);
			response.sendRedirect("addstate.jsp");
		}
		
		if(flag.equals("viewstate"))
		{
			viewstate(request,response);
			response.sendRedirect("Stateview.jsp");
		}
		if(flag.equals("loadstateAJAX"))
		{
			loadstate(request,response);
			response.sendRedirect("statejson.jsp");
		}
		
		
		
	}
	public void addstat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		Countrydao s = new Countrydao();
		List ls = s.search1();
		System.out.println(ls.size());
		
		HttpSession cs = request.getSession();
		cs.setAttribute("data",ls);
		response.sendRedirect("addstate.jsp");
		
	}
	public void insertstat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int cid = Integer.parseInt(request.getParameter("countryId"));
		String statename = request.getParameter("sn");
		System.out.println(cid);
		System.out.println(statename);
		
		Countryvo cv = new Countryvo();
		cv.setId(cid);
		
		Statevo sv = new Statevo();
		sv.setStatename(statename);
		sv.setCountryvo(cv);
		
		Statedao sd = new Statedao();
		sd.insertstate(sv);
		
	}
	public void viewstate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Statedao c = new Statedao();
		List ls = c.search();
		System.out.println(ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
	
	}
	public void loadstate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int cid = Integer.parseInt(request.getParameter("countryid"));
		
		Countryvo cv = new Countryvo();
		cv.setId(cid);
		
		Statevo sv = new Statevo();
		sv.setCountryvo(cv);
		
		Statedao s = new Statedao();
		List ls = s.loadstateajax(sv);
		
		System.out.println(ls.size());
		
		HttpSession s1 = request.getSession();
		s1.setAttribute("data",ls);
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
