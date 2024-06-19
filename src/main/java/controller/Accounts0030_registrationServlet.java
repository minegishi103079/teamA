package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.AccountsBean;
import validation.AccountsFormCheck;

/**
 * Servlet implementation class Sales0030_AccountsRegistrationServlet
 */
@WebServlet("/Accounts0030")
public class Accounts0030_registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0030_registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("page", "3");
		
		request.setCharacterEncoding("UTF-8");
		
		this.getServletContext().getRequestDispatcher("/Accounts0030_registration.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AccountsFormCheck af = new AccountsFormCheck();
		if(af.validate(request)) {
		HttpSession session = request.getSession();

		
		String n = request.getParameter("name");
		String m = request.getParameter("mail");
		String pw1 = request.getParameter("password1");
		String at = request.getParameter("authority");
		
		AccountsBean ab=new AccountsBean(0,n,m,pw1,at);
		
		session.setAttribute("accountInsert", ab);
		
		
		response.sendRedirect("Accounts0031");
		
				}else {
					request.setAttribute("errors", af.getErrors());
					doGet(request, response);
				}
		
	}

}
