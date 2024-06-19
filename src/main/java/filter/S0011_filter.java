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

import model.beans.SalesBean;

/**
 * Servlet Filter implementation class S0011_filter
 */
@WebFilter("*")
public class S0011_filter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public S0011_filter() {
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
		var req = (HttpServletRequest) request;
		var res = (HttpServletResponse) response;

		String path = req.getServletPath();
		
		HttpSession session = req.getSession();
		
		SalesBean sb = (SalesBean)session.getAttribute("saleInsert");
		if(path.equals("/Sales0011")) {
			if(sb == null) {
				res.sendRedirect("Sales0010");
				return;
			}
		}
			chain.doFilter(request, response);
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
