package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.RegistrationService;

/**
 * Servlet implementation class Sales0011check_Servlet
 */
@WebServlet("/Sales0011check_Servlet")
public class Sales0011check_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0011check_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		RegistrationService rs=new RegistrationService();
		String date =request.getParameter("sale_date");
		int ai =Integer.parseInt(request.getParameter("account_id"));
		int ci=Integer.parseInt(request.getParameter("category_id"));
		String tn =request.getParameter("trade_name");
		int up=Integer.parseInt(request.getParameter("unit_price"));
		int sn=Integer.parseInt(request.getParameter("sale_number"));
		String n=request.getParameter("note");
		String nm=request.getParameter("name");
		String cn=request.getParameter("category_name");
		
		
		nm=rs.accountsname(request.getParameter("account_id"));
		cn=rs.categoryname(request.getParameter("category_id"));
		
		request.setAttribute("sale_date", date);
		request.setAttribute("account_id", ai);
		request.setAttribute("category_id", ci);
		request.setAttribute("trade_name", tn);
		request.setAttribute("unit_price", up);
		request.setAttribute("sale_number", sn);
		request.setAttribute("note", n);
		request.setAttribute("name",nm );
		request.setAttribute("category_name", cn);
		
		
		this.getServletContext().getRequestDispatcher("/Sale0011_check.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		
	}

}
