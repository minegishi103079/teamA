package util;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import model.beans.AccountsBean;
import model.beans.ListBean;
import model.beans.SearchResultBean;
import model.services.RegistrationService;

public class CommonUtil {
	
	// ToDo:入力側の日付確認
	public static LocalDate str_LocalDate(String str) throws Exception{
		return LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public static int str_Int(String str) throws Exception{
		int num = Integer.parseInt(str);
		return num;
	}
	
	public static String localDateFormat(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
	
	public static String numberComma(int num) {
		NumberFormat ni = NumberFormat.getNumberInstance();
		return ni.format(num);
	}
	

	// jsp側のnameと合わせる。入力されない値は仮決めする。
	public static ListBean request_ListBean(HttpServletRequest request) {
		ListBean sales = null;
		RegistrationService rs = new RegistrationService();
		try {
			sales = new ListBean(
					str_Int(request.getParameter("sale_id")),
					CommonUtil.str_LocalDate(request.getParameter("sale_date")),
					str_Int(request.getParameter("account_id")),
					str_Int(request.getParameter("category_id")),
					request.getParameter("trade_name"),
					str_Int(request.getParameter("unit_price")),
					str_Int(request.getParameter("sale_number")),
					request.getParameter("note"),
					rs.accountsName(request.getParameter("account_id")),
					rs.categoryName(request.getParameter("category_id"))
			);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sales;
	}
	
	
	public static SearchResultBean request_SearchBean(HttpServletRequest request) {
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String account = request.getParameter("account_id");
		String category = request.getParameter("category_id");
		String trade = request.getParameter("trade_name");
		String note = request.getParameter("note");
		
		return new SearchResultBean(date1, date2, account, category, trade, note);
	}
	
	public static AccountsBean request_AcoountSearchBean(HttpServletRequest request) {
		int  account_id = 0;
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = null;
		String authority = request.getParameter("authority");
		
		return new AccountsBean(account_id,name,mail,password,authority);
	}
	
	
	
	
	
}
