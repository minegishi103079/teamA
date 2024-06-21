package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.SalesBean;
import model.services.SalesService;
import util.CommonUtil;

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
		HttpSession session = request.getSession();
		if (session.getAttribute("sales") == null) {
			response.sendRedirect("Sales0023");
			return;
		}
		
		request.getRequestDispatcher("/Sales0024_detailEditCheck.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 変更を適用して、一覧画面に戻す
		request.setCharacterEncoding("UTF-8");
		
		SalesService ss = new SalesService();
		
		HttpSession session = request.getSession();
		SalesBean sb = CommonUtil.request_SalesBean(request);
		if (!sb.equals((SalesBean)session.getAttribute("salesCheck"))) {
			doGet(request, response);
			return;
		}
		
		ss.salesUpdate(request);
		session.removeAttribute("sales");
		session.removeAttribute("salesCheck");
		
		response.sendRedirect("Sales0021");
	}

}
