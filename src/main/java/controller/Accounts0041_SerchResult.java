package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.AccountsBean;
import model.services.AccountsService_2;

/**
 * Servlet implementation class Accounts0041_SerchResult
 */
@WebServlet("/Accounts0041_SerchResult")
public class Accounts0041_SerchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0041_SerchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		AccountsService_2 as2 = new AccountsService_2();
		// sessionから検索結果をまとめたもの＝beanを受け取る
		AccountsBean bean = (AccountsBean)session.getAttribute("search");
		// beanをもとにリストを作成し、requestにセットする。
		request.setAttribute("accountlist", as2.searchResultList(bean));
		
		
		//request.getRequestDispatcher("/Sales0021_SearchResult.jsp").forward(request, response);
		
		
		
		
		
		
		
		//request.setAttribute("Accounts", as2.selectAll());
		
		request.getRequestDispatcher("/Accounts0041_SerchResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
