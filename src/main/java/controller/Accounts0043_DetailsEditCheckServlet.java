package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.AccountsService_2;
import util.CommonUtil;

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
		request.setCharacterEncoding("UTF-8");
		
		
		request.getRequestDispatcher("/Accounts0043_DetailsEditCheck.jsp").forward(request, response);
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
