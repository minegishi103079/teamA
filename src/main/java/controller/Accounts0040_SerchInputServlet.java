package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.Accounts_formCheck;
import util.CommonUtil;

/**
 * Servlet implementation class Accounts0040_SerchInputServlet
 */
@WebServlet("/Accounts0040_SerchInputServlet")
public class Accounts0040_SerchInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounts0040_SerchInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("accountlist");
		
//		RegistrationService rs=new RegistrationService();
//		request.setAttribute("accounts", rs.accounts());
//		request.setAttribute("categories", rs.categories());
		this.getServletContext().getRequestDispatcher("/Accounts0040_SerchInput.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 検索結果を反映する
		
				request.setCharacterEncoding("UTF-8");
				
				Accounts_formCheck af = new Accounts_formCheck();
				
				// フォームチェック、問題なければtrue
				if(af.validate(request)) {
					
					HttpSession session = request.getSession();
					// 検索結果をbeanに入れる
					session.setAttribute("search", CommonUtil.request_SearchBean(request));
					//↑まだsaleのやつから変更してない
					response.sendRedirect("Accounts0041_SerchResultServlet");
					
				}else {
					request.setAttribute("errors", af.getErrors());
					doGet(request, response);
				}
				
			
		// TODO Auto-generated method stub
		//response.sendRedirect("Accounts0041_SerchResultServlet");
	}

}
