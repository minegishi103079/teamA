package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.Sales_formcheck;
import model.services.RegistrationService;
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
		
		// ほかのページから戻ってきたとき。
		
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("/Sales0021_SearchResult.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 検索結果を反映する
		
		request.setCharacterEncoding("UTF-8");
		
		Sales_formcheck sf = new Sales_formcheck();
		
		if(sf.validate(request)) {
			
		HttpSession session = request.getSession();
		SalesService ss = new SalesService();
		session.setAttribute("salelist", ss.searchResult(request));
		
//		request.setAttribute("sales", ss.searchResult(request));
		
		request.getRequestDispatcher("/Sales0021_SearchResult.jsp").forward(request, response);
		
		}else {
			request.setAttribute("errors", sf.getErrors());
			RegistrationService rs=new RegistrationService();
			request.setAttribute("accounts", rs.accounts());
			request.setAttribute("categories", rs.categories());
			
			request.getRequestDispatcher("/Sales0020_SerchInput.jsp").forward(request, response);
			
			
		}
			
		
	}

}
