package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.ListBean;
import model.services.SalesService;

/**
 * Servlet implementation class Sales0022_SaleDetailServlet
 */
@WebServlet("/Sales0022")
public class Sales0022_SaleDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0022_SaleDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ほかのページから戻ってくる。
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 検索結果画面から詳細ボタンが押される。
		
		request.setCharacterEncoding("UTF-8");
		
		
		SalesService ss = new SalesService();
		ListBean sale = ss.salesDetailSales(request.getParameter("sale_id"));
		request.setAttribute("sales", sale);
		
		request.getRequestDispatcher("/Sales0022_SaleDetail.jsp").forward(request, response);
	}

}
