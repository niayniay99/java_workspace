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
import VO.Countryvo;

/**
 * Servlet implementation class CountryController
 */
@WebServlet("/CountryController")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryController() {
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
		
		if(flag.equals("addcountry"))
		{
			addcountry(request,response);
			response.sendRedirect("addcountry.jsp");
		}
		if(flag.equals("search"))
		{
			search(request,response);
			response.sendRedirect("Viewcountry.jsp");
		}
		if(flag.equals("loadstateajax"))
		{
			search(request,response);
			response.sendRedirect("StateCountryAJAX.jsp");
		}
	}
	public void addcountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cn =request.getParameter("cn");
		String cd =request.getParameter("cdesc");
		Countryvo cv = new Countryvo();
		cv.setCountryname(cn);
		cv.setCountrydesc(cd);
		Countrydao d = new Countrydao();
		d.insertcn(cv);
	}
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Countrydao c = new Countrydao();
		List ls = c.search();
		System.out.println(ls.size());
		
		HttpSession s = request.getSession();
		s.setAttribute("data",ls);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
