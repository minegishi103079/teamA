package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.ListBean;
import model.services.SalesService;

/**
 * Servlet implementation class Sales0022_SaleDetailServlet
 */
@WebServlet("/Sales0022")
public class Sales0022_saleDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0022_saleDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 検索結果画面から詳細ボタンが押される。
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		session.removeAttribute("sales");
		
		SalesService ss = new SalesService();
		
		// 不正なsale_idだった時に検索結果に戻す
		ListBean sale = ss.salesDetailSales(request.getParameter("sale_id"));
		if (sale == null) {
			response.sendRedirect("Sales0021");
			return;
		}
		request.setAttribute("sales", sale);
		
		
		request.getRequestDispatcher("/Sales0022_saleDetail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
