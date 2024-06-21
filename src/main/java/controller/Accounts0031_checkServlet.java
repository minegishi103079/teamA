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

/**
 * Servlet implementation class Accounts0031_CheckServlet
 */
@WebServlet("/Accounts0031")
public class Accounts0031_checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Accounts0031_checkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("page", "3");
		
		this.getServletContext().getRequestDispatcher("/Accounts0031_registrationCheck.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AccountsService_2 as = new AccountsService_2();
		
//		AccountsBean ab = new AccountsBean(
//				0,
//				request.getParameter("name"),
//				request.getParameter("mail"),
//				request.getParameter("password1"),
//				request.getParameter("authority"));
		HttpSession session = request.getSession();
		AccountsBean ab = CommonUtil.request_AcoountsBean(request);
		if (!ab.equals((AccountsBean)session.getAttribute("accountInsert"))) {
			doGet(request, response);
			return;
		}

		try {

			as.accountsInsert(ab);
			session.removeAttribute("accountInsert");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Accounts0030");
	}

}
