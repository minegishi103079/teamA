package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.AccountsBean;
import model.services.AccountsService_2;
import validation.AccountsFormCheck;

/**
 * Servlet implementation class Accounts0042_DetailsEdit
 */
@WebServlet("/Accounts0042")
public class Accounts0042_detailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0042_detailsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		if (session.getAttribute("accounts") == null) {
			AccountsService_2 as = new AccountsService_2();
			AccountsBean ab = as.AccountsDetailSales(request.getParameter("account_id"));
			
			if(ab == null) {
				response.sendRedirect("Accounts0041");
				return;
			}
			
			request.setAttribute("accounts", ab);
		}
		
		
		request.getRequestDispatcher("/Accounts0042_detailsEdit.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountsFormCheck af = new AccountsFormCheck();
		request.setCharacterEncoding("UTF-8");
		if(af.validate(request)) {
		HttpSession session = request.getSession();

		int ai=Integer.parseInt(request.getParameter("account_id"));
		String n = request.getParameter("name");
		String m = request.getParameter("mail");
		String pw1 = request.getParameter("password1");
		String at = request.getParameter("authority");
		AccountsBean ab=new AccountsBean(ai,n,m,pw1,at);
		session.setAttribute("accounts", ab);
		
		response.sendRedirect("Accounts0043");

		
		}else {
			request.setAttribute("errors", af.getErrors());
			doGet(request, response);
		}
	}

}
