package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.services.RegistrationService;
import model.services.SaleService_2;
import validation.SalesFormCheck;

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
		
		SalesFormCheck sf = new SalesFormCheck();
		
		// フォームチェック、問題なければtrue
		if(sf.validate(request)) {
			
			HttpSession session = request.getSession();
			
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
			
			
			nm=rs.accountsName(request.getParameter("account_id"));
			cn=rs.categoryName(request.getParameter("category_id"));
			
			request.setAttribute("sale_date",date);
			request.setAttribute("account_id",ai);
			request.setAttribute("category_id",ci);
			request.setAttribute("trade_name",tn);
			request.setAttribute("unit_price",up);
			request.setAttribute("sale_number",sn);
			request.setAttribute("note",n);
			request.setAttribute("name",nm );
			request.setAttribute("category_name",cn);
			
			this.getServletContext().getRequestDispatcher("/Sales0011_check.jsp").forward(request,response);
			
			// 検索結果をbeanに入れる
//			session.setAttribute("search", CommonUtil.request_SearchBean(request));
//			response.sendRedirect("Sales0021");
			
		}else {
			request.setAttribute("errors", sf.getErrors());
			request.getRequestDispatcher("Sales0010").forward(request, response);
			//response.sendRedirect("Sale0010Registration_Servlet");
		}
		
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
