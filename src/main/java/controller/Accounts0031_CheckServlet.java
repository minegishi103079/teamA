package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.Accounts_formCheck;
import model.services.AccountsService_2;
import util.CommonUtil;

/**
 * Servlet implementation class Accounts0031_CheckServlet
 */
@WebServlet("/Accounts0031_CheckServlet")
public class Accounts0031_CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Accounts0031_CheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Accounts_formCheck af = new Accounts_formCheck();
		if(af.validate(request)) {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		AccountsService_2 as = new AccountsService_2();
		String n = request.getParameter("name");
		String m = request.getParameter("mail");
		String pw1 = request.getParameter("password1");
		String pw2 = request.getParameter("password2");
		int at = Integer.parseInt(request.getParameter("authority"));

		request.setAttribute("name", n);
		request.setAttribute("mail", m);
		request.setAttribute("password1", pw1);
		request.setAttribute("password2", pw2);
		request.setAttribute("authority", at);

		this.getServletContext().getRequestDispatcher("/Accounts0031_Registrationcheck.jsp").forward(request, response);
				}else {
					request.setAttribute("errors", af.getErrors());
					request.getRequestDispatcher("Accounts0030_RegistrationServlet").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountsService_2 as = new AccountsService_2();

		try {

			as.accountsInsert(request.getParameter("name"),
					request.getParameter("mail"),
					request.getParameter("password1"),
					CommonUtil.str_Int(request.getParameter("authority")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Accounts0030_RegistrationServlet");
	}

}
