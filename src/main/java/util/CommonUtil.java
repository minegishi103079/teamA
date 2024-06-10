package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import model.beans.SalesBean;

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
	
	// jsp側のnameと合わせる
	public static SalesBean request_Sales(HttpServletRequest request) {
		SalesBean sales = null;
		try {
			sales = new SalesBean(
					str_Int(request.getParameter("sale_id")),
					CommonUtil.str_LocalDate(request.getParameter("sale_date")),
					str_Int(request.getParameter("account_id")),
					str_Int(request.getParameter("category_id")),
					request.getParameter("trade_name"),
					str_Int(request.getParameter("unit_price")),
					str_Int(request.getParameter("sale_number")),
					request.getParameter("note")
			);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sales;
		
	}
	
	
}
