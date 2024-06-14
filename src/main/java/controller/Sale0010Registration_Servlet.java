package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.RegistrationService;
import model.services.SaleService_2;

/**
 * Servlet implementation class Sale0011_check_Servlet
 */
@WebServlet("/Sale0010Registration_Servlet")
public class Sale0010Registration_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sale0010Registration_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SaleService_2 s2 = new SaleService_2();
		RegistrationService rs=new RegistrationService();
		request.setCharacterEncoding("UTF-8");
		rs.accounts();
		rs.categories();
		
		request.setAttribute("accounts", rs.accounts());
		request.setAttribute("categories", rs.categories());
		
		this.getServletContext().getRequestDispatcher("/Sale0010_Registration.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
