package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.services.SaleService_2;
import util.CommonUtil;

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
		
		request.setCharacterEncoding("UTF-8");
		SaleService_2 s2=new SaleService_2();
		
		
		s2.salesInsert(CommonUtil.request_SalesBean(request));
		HttpSession session = request.getSession();
		session.removeAttribute("saleInsert");
		
		response.sendRedirect("Sales0010");
	}
}
