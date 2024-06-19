package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.AccountsBean;

/**
 * Servlet Filter implementation class A0041_filter
 */
@WebFilter("/*")
public class A0041_filter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public A0041_filter() {
        super();
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
		var req = (HttpServletRequest) request;
		var res = (HttpServletResponse) response;

		String path = req.getServletPath();
		
		HttpSession session = req.getSession();
		
		AccountsBean ab = (AccountsBean)session.getAttribute("accountSearch");
		
		if (path.equals("/Accounts0041")){
			if(ab==null) {
				res.sendRedirect("Accounts0040");
				return;
			}
		}
			chain.doFilter(request, response);
}
		// pass the request along the filter chain
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
