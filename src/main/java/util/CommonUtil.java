package util;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import form.ListBean;
import form.SearchResultBean;
import model.beans.AccountsBean;
import model.beans.SalesBean;
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
	
	
	public static String authorityFormat(String str) {
		str = str != null ? str: "";
		switch(str) {
		case "0":
			return "権限なし";
		case "1":
			return "売上閲覧";
		case "2":
			return "売上担当";
		case "3":
			return "管理者";
		default:
			return "権限なし";
		
		}
	}
	

	// jsp側のnameと合わせる。入力されない値は仮決めする。
	public static ListBean request_ListBean(HttpServletRequest request) {
		ListBean sales = null;
		RegistrationService rs = new RegistrationService();
		String sale_id = request.getParameter("sale_id") != null ? request.getParameter("sale_id"): "0";
		try {
			sales = new ListBean(
					str_Int(sale_id),
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
	
	public static AccountsBean request_AcoountsBean(HttpServletRequest request) {
		int account_id=0;
		try {
			account_id = CommonUtil.str_Int(request.getParameter("account_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password1");
		String authority = request.getParameter("authority");
		
		return new AccountsBean(account_id,name,mail,password,authority);
	}
	
	public static SalesBean request_SalesBean(HttpServletRequest request) {
		int sale_id=0;
		try {
			sale_id = CommonUtil.str_Int(request.getParameter("sale_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		LocalDate sale_date=null;
		try {
			sale_date = CommonUtil.str_LocalDate(request.getParameter("sale_date"));
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		int account_id=0;
		try {
			account_id = CommonUtil.str_Int(request.getParameter("account_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int category_id=0;
		try {
			category_id = CommonUtil.str_Int(request.getParameter("category_id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String trade_name = request.getParameter("trade_name");
		
		int unit_price=0;
		try {
			unit_price = CommonUtil.str_Int(request.getParameter("unit_price"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int sale_number=0;
		try {
			sale_number = CommonUtil.str_Int(request.getParameter("sale_number"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String note = request.getParameter("note");
		
		return new SalesBean(sale_id,sale_date,account_id,category_id,trade_name,unit_price,sale_number,note);
	}
	
//	CommonUtil.str_LocalDate(request.getParameter("sale_date")),
//	str_Int(request.getParameter("account_id")),
//	str_Int(request.getParameter("category_id")),
//	request.getParameter("trade_name"),
//	str_Int(request.getParameter("unit_price")),
//	str_Int(request.getParameter("sale_number")),
//	request.getParameter("note"),
	
	
	
}
