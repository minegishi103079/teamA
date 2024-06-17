package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.ListBean;
import model.beans.SalesBean;
import model.services.RegistrationService;
import util.CommonUtil;
import validation.SalesFormCheck;

/**
 * Servlet implementation class Sale0011_check_Servlet
 */
@WebServlet("/Sales0010")
public class Sales0010_registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0010_registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status");
		request.setAttribute("status", "1");	// nav
		
		RegistrationService rs=new RegistrationService();
		request.setCharacterEncoding("UTF-8");
		rs.accounts();
		rs.categories();
		
		request.setAttribute("accounts", rs.accounts());
		request.setAttribute("categories", rs.categories());
		
		this.getServletContext().getRequestDispatcher("/Sales0010_registration.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

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
			
			SalesBean sb=new SalesBean(date,ai,ci,tn,up,sn,n);
			try{
				ListBean lb=new ListBean(0,CommonUtil.str_LocalDate(date),ai,ci,tn,up,sn,n,nm,cn);
				session.setAttribute("sales",lb);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			/*session.setAttribute("sale_date",date);
			request.setAttribute("account_id",ai);
			request.setAttribute("category_id",ci);
			request.setAttribute("trade_name",tn);
			request.setAttribute("unit_price",up);
			request.setAttribute("sale_number",sn);
			request.setAttribute("note",n);
			request.setAttribute("name",nm );
			request.setAttribute("category_name",cn)*/;
			
			response.sendRedirect("Sales0011");
			
			// 検索結果をbeanに入れる
//			session.setAttribute("search", CommonUtil.request_SearchBean(request));
//			response.sendRedirect("Sales0021");
			
		}else {
			request.setAttribute("errors", sf.getErrors());
			doGet(request, response);
			//response.sendRedirect("Sale0010Registration_Servlet");
		}
	}
}
