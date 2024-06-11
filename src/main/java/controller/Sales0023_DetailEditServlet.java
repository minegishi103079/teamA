package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		// Detailのデータを上手いこと受け渡す or もう一回引っ張り出す
		
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("sales", request.getParameter("sales") );
		
		
		request.getRequestDispatcher("/Sales0023_DetailEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// 編集確認から戻ってきたときに入力したデータを残す？
		
		doGet(request, response);
	}

}
