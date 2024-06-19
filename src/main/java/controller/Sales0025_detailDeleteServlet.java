package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.ListBean;
import model.services.SaleService_2;
import model.services.SalesService;

/**
 * Servlet implementation class Sales0025_DeleteServlet
 */
@WebServlet("/Sales0025")
public class Sales0025_detailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0025_detailDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// S0024でセッションを取得した後、削除に飛んでくる。
//		HttpSession session = request.getSession();
//		if (session.getAttribute("sales") != null) {
//			session.removeAttribute("sales");
//			response.sendRedirect("Sales0021");
//			return;
//		}
//		
		SalesService ss = new SalesService();
		ListBean sale = ss.salesDetailSales(request.getParameter("sale_id"));
		if (sale == null) {
			response.sendRedirect("Sales0021");
			return;
		}
		request.setAttribute("sales", sale);
		
		request.setAttribute("sales", ss.salesDetailSales(request.getParameter("sale_id")) );
		
		
		request.getRequestDispatcher("/Sales0025_detailDelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 削除の処理をする
		SaleService_2 s2 = new SaleService_2();
		s2.salesDelete(request.getParameter("sale_id"));
		
		response.sendRedirect("Sales0021");
		
	}

}
