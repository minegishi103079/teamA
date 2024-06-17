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
import util.CommonUtil;
import validation.AccountsFormCheck;

/**
 * Servlet implementation class Accounts0043_DetailsEditCheckServlet
 */
@WebServlet("/Accounts0043")
public class Accounts0043_DetailsEditCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0043_DetailsEditCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AccountsFormCheck af = new AccountsFormCheck();
		if(af.validate(request)) {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		AccountsService_2 as = new AccountsService_2();
		int ai=Integer.parseInt(request.getParameter("account_id"));
		String n = request.getParameter("name");
		String m = request.getParameter("mail");
		String pw1 = request.getParameter("password1");
		String pw2 = request.getParameter("password2");
		String at = request.getParameter("authority");
		AccountsBean ab=new AccountsBean(ai,n,m,pw1,at);
		request.setAttribute("name", n);
		request.setAttribute("mail", m);
		request.setAttribute("password1", pw1);
		request.setAttribute("password2", pw2);
		request.setAttribute("authority", at);
		request.setAttribute("accounts", ab);
		

		this.getServletContext().getRequestDispatcher("/Accounts0043_DetailsEditCheck.jsp").forward(request, response);
				}else {
					request.setAttribute("errors", af.getErrors());
					request.getRequestDispatcher("Accounts0042").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		AccountsService_2 as = new AccountsService_2();

		try {

			as.accountsUpdate(request.getParameter("name"),
					request.getParameter("mail"),
					request.getParameter("password1"),
					CommonUtil.str_Int(request.getParameter("authority")),
					CommonUtil.str_Int(request.getParameter("account_id")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Accounts0041");
	}
	
	}
