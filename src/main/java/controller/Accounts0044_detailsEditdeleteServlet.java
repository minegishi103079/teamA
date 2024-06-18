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
@WebServlet("/Accounts0044")
public class Accounts0044_detailsEditdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0044_detailsEditdeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		AccountsService_2 as2 = new AccountsService_2();
		request.setAttribute("accounts", as2.AccountsDetailSales(request.getParameter("account_id")) );
		
		
		request.getRequestDispatcher("/Accounts0044_detailsEditdelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 削除の処理をする
		AccountsService_2 as2 = new AccountsService_2();
		as2.accountsDelete(request.getParameter("account_id"));
		
		
		response.sendRedirect("Accounts0041");
	}

}
