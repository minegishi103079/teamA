package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.services.RegistrationService;
import validation.AccountsFormCheck;

/**
 * Servlet implementation class Sales0030_AccountsRegistrationServlet
 */
@WebServlet("/Accounts0030")
public class Accounts0030_RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0030_RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status");
		request.setAttribute("status", "3");	// nav
		
		request.setCharacterEncoding("UTF-8");
		
		RegistrationService rs=new RegistrationService();
		rs.accounts();
		
		request.setAttribute("accounts", rs.accounts());
		
		this.getServletContext().getRequestDispatcher("/Accounts0030_Registration.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountsFormCheck af = new AccountsFormCheck();
		if(af.validate(request)) {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		String n = request.getParameter("name");
		String m = request.getParameter("mail");
		String pw1 = request.getParameter("password1");
		String pw2 = request.getParameter("password2");
		int at = Integer.parseInt(request.getParameter("authority"));
		
		session.setAttribute("name", n);
		session.setAttribute("mail", m);
		session.setAttribute("password1", pw1);
		session.setAttribute("password2", pw2);
		session.setAttribute("authority", at);
		
		response.sendRedirect("Accounts0031");
		
				}else {
					request.setAttribute("errors", af.getErrors());
					doGet(request, response);
				}
		
	}

}
