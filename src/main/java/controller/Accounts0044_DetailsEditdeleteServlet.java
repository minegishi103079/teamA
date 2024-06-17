package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.AccountsService_2;

/**
 * Servlet implementation class Accounts0044_DetailsEditdeleteServlet
 */
@WebServlet("/Accounts0044_DetailsEditdeleteServlet")
public class Accounts0044_DetailsEditdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0044_DetailsEditdeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		AccountsService_2 as2 = new AccountsService_2();
		request.setAttribute("accounts", as2.AccountsDetailSales(request.getParameter("sale_id")) );
		
		
		request.getRequestDispatcher("/Accounts0044_DetailsEditdelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.sendRedirect("Accounts0041_SerchResultServlet");
	}

}
