package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.services.RegistrationService;
import model.services.SalesService;
import util.CommonUtil;
import validation.SalesFormCheck;

/**
 * Servlet implementation class Sales0023_DetailEditServlet
 */
@WebServlet("/Sales0023")
public class Sales0023_DetailEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales0023_DetailEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Detailからsale_idを受け取って、salesというListBeanにして再びセットする。
		
		
		request.setCharacterEncoding("UTF-8");
		
		SalesService ss = new SalesService();
		request.setAttribute("sales", ss.salesDetailSales(request.getParameter("sale_id")) );
		
		RegistrationService rs=new RegistrationService();
		request.setAttribute("accounts", rs.accounts());
		request.setAttribute("categories", rs.categories());
		
		request.getRequestDispatcher("/Sales0023_DetailEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// ToDo:フォームチェックの実装
		SalesFormCheck sf = new SalesFormCheck();
		if( sf.validate(request)) {
			// 受け取ったデータをListBeanに入れて渡す
			HttpSession session = request.getSession();
			session.setAttribute("sales", CommonUtil.request_ListBean(request));
//			request.setAttribute("sales", CommonUtil.request_ListBean(request));
			
			response.sendRedirect("Sales0024");
		} else {
			request.setAttribute("errors", sf.getErrors());
			doGet(request, response);
		}
		
		
		
		
		
	}

}
