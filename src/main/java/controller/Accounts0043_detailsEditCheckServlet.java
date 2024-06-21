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
 * Servlet implementation class Accounts0043_DetailsEditCheckServlet
 */
@WebServlet("/Accounts0043")
public class Accounts0043_detailsEditCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0043_detailsEditCheckServlet() {
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
			response.sendRedirect("Accounts0042");
			return;
		}
		
		request.getRequestDispatcher("/Accounts0043_detailsEditCheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		AccountsService_2 as = new AccountsService_2();
		
		HttpSession session = request.getSession();
		AccountsBean ab = CommonUtil.request_AcoountsBean(request);
		if (!ab.equals((AccountsBean)session.getAttribute("accounts"))) {
			doGet(request, response);
			return;
		}

		try {
			as.accountsUpdate(ab);
			session.removeAttribute("accounts");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Accounts0041");
	}
	
	}
//
