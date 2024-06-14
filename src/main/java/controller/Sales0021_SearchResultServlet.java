package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.SearchResultBean;
import model.services.SalesService;

/**
 * Servlet implementation class SalelistServlet
 */
@WebServlet("/Sales0021")
public class Sales0021_SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0021_SearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ToDo:sessionにBeanで保管されている検索条件から、一覧を表示
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		SalesService ss = new SalesService();
		// sessionから検索結果をまとめたもの＝beanを受け取る
		SearchResultBean bean = (SearchResultBean)session.getAttribute("search");
		// beanをもとにリストを作成し、requestにセットする。
		request.setAttribute("salelist", ss.salesSearchResultList(bean));
		
		
		request.getRequestDispatcher("/Sales0021_SearchResult.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
