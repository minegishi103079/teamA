package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.SaleService_2;

/**
 * Servlet implementation class Sales0011check_Servlet
 */
@WebServlet("/Sales0011")
public class Sales0011_checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0011_checkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	
		request.getRequestDispatcher("/Sales0011_check.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String bt[]=request.getParameterValues("button");
//		request.setAttribute("button",bt);
		request.setCharacterEncoding("UTF-8");
		SaleService_2 s2=new SaleService_2();
		s2.salesInsert(request.getParameter("sale_date"),
						Integer.parseInt(request.getParameter("account_id")),
						Integer.parseInt(request.getParameter("category_id")),
						request.getParameter("trade_name"),
						Integer.parseInt(request.getParameter("unit_price")),
						Integer.parseInt(request.getParameter("sale_number")),
						request.getParameter("note"));
		
		response.sendRedirect("Sales0010");
	}
}
