package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.AccountsService_2;
import model.services.RegistrationService;

/**
 * Servlet implementation class Sales0030_AccountsRegistrationServlet
 */
@WebServlet("/Accounts0030_RegistrationServlet")
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
		request.setCharacterEncoding("UTF-8");
		AccountsService_2 a2 = new AccountsService_2();
		
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
		response.sendRedirect("Accounts0031_CheckServlet");
	}

}
