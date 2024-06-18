package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.CommonUtil;
import validation.AccountsFormCheck;

/**
 * Servlet implementation class Accounts0040_SerchInputServlet
 */
@WebServlet("/Accounts0040")
public class Accounts0040_serchInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0040_serchInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		request.setAttribute("status", "4");	// nav
		
		
		HttpSession session = request.getSession();
		session.removeAttribute("accountlist");
		this.getServletContext().getRequestDispatcher("/Accounts0040_serchInput.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 検索結果を反映する
		
				request.setCharacterEncoding("UTF-8");
				
				AccountsFormCheck af = new AccountsFormCheck();
				
				// フォームチェック、問題なければtrue
				if(af.validate2(request)) {
					
					HttpSession session = request.getSession();
					// 検索結果をbeanに入れる
					session.setAttribute("search", CommonUtil.request_AcoountSearchBean(request));
					response.sendRedirect("Accounts0041");
					
				}else {
					request.setAttribute("errors", af.getErrors());
					doGet(request, response);
				}
				
			
		// TODO Auto-generated method stub
		//response.sendRedirect("Accounts0041_SerchResultServlet");
	}

}
