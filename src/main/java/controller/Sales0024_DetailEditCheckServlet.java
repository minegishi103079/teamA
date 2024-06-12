package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.SaleService_2;

/**
 * Servlet implementation class Sales0024_Servlet
 */
@WebServlet("/Sales0024")
public class Sales0024_DetailEditCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0024_DetailEditCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		// ToDo:フォームの入力をチェックする
		
		
		// 受け取ったデータをListBeanに入れて渡す
//		request.setAttribute("sales", CommonUtil.request_ListBean(request));
		request.getRequestDispatcher("/Sales0024_DetailEditCheck.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 変更を適用して、一覧画面に戻す
		
		
		SaleService_2 ss2 = new SaleService_2();
		// ToDo:リクエストから値を取り出す。
//		ss2.salesupdate(getServletInfo(), 0, 0, getServletName(), 0, 0, getServletInfo());
		
		
		response.sendRedirect("Sales0021");
	}

}
