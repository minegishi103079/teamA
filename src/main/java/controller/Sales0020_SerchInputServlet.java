package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.services.RegistrationService;

/**
 * Servlet implementation class Sales0020_SerchInputServlet
 */
@WebServlet("/Sales0020")
public class Sales0020_SerchInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0020_SerchInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 検索画面に来た段階で、検索結果のセッションを消す。
		HttpSession session = request.getSession();
		session.removeAttribute("salelist");
		
		RegistrationService rs=new RegistrationService();
		request.setAttribute("accounts", rs.accounts());
		request.setAttribute("categories", rs.categories());
		
		request.getRequestDispatcher("/Sales0020_SerchInput.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
