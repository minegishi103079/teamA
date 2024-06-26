package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.AccountsBean;
import validation.LoginFormCheck;

/**
 * Servlet implementation class C0010_Login
 */
@WebServlet("/C0010_login")
public class C0010_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C0010_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html:charset=UTF-8");
		
		this.getServletContext().getRequestDispatcher("/C0010_login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		LoginFormCheck lf = new LoginFormCheck();
		
		if(lf.validate(request)) {
			HttpSession session = request.getSession();
			AccountsBean bean = lf.getAccount();
			
			if(bean == null) {
				doGet(request, response);
			}else {
				session.setAttribute("bean", bean);
				response.sendRedirect("C0020");
			}
			
		}else {
			request.setAttribute("errors", lf.getErrors());
			doGet(request, response);
		}
		
		
	}

}
