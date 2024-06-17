package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.SalesService;

/**
 * Servlet implementation class Sales0024_Servlet
 */
@WebServlet("/Sales0024")
public class Sales0024_detailEditCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0024_detailEditCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("/Sales0024_detailEditCheck.jsp").forward(request, response);
//		HttpSession session = request.getSession();
//		session.removeAttribute("sales");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 変更を適用して、一覧画面に戻す
		request.setCharacterEncoding("UTF-8");
		
		SalesService ss = new SalesService();
		ss.salesUpdate(request);
		
		
		response.sendRedirect("Sales0021");
	}

}
