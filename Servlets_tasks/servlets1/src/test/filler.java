package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class filler
 */
@WebFilter("/*")
public class filler implements Filter {

    /**
     * Default constructor. 
     */
    public filler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Filter");
		String un=(String)request.getParameter("un");
		String pw=(String)request.getParameter("pw");
		String ipAddress = request.getRemoteAddr();
	    
		response.setContentType("text/html");
	//	PrintWriter p = response.getWriter();
		if((pw!=null) && (un!=null))
		{
			if((un.equals("admin")) && (pw.equals("admin")))	
			{
			// pass the request along the filter chain		
			RequestDispatcher rd=request.getRequestDispatcher("welcomefiller.jsp");  
			rd.include(request, response);
			// Log the IP address and current time stamp.
			System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());
			}
			else
			{
			System.out.println("UserName Or Password incorrect");
			System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());
			chain.doFilter(request,response);
			}
		}
		else
		{
		chain.doFilter(request,response);
		}
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
