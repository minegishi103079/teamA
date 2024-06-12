package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.beans.ListBean;
import util.CommonUtil;
import util.DbUtil;

public class SalesService {
	

	
	
	
	public static void main(String[] args) {
		
		String str = "";
		Integer.parseInt(str);
		
	}
	
	public ListBean detailSales(String sale_id) {
		String sql = "SELECT * FROM sales s "
				+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
				+ "LEFT JOIN categories c ON s.category_id = c.category_id "
				+ "WHERE sale_id = ?";
		ListBean sales = null;
		
		
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, sale_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sales = new ListBean(
						rs.getInt("sale_id"), 
						CommonUtil.str_LocalDate(rs.getString("sale_date") ), 
						rs.getInt("account_id"), 
						rs.getInt("category_id"), 
						rs.getString("trade_name"), 
						rs.getInt("unit_price"), 
						rs.getInt("sale_number"), 
						rs.getString("note"),
						rs.getString("name"),
						rs.getString("category_name")
						);
			};
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sales;
	}
	
	
	public ArrayList<ListBean> selectAll() {
		String sql = "SELECT * FROM sales s "
		+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
		+ "LEFT JOIN categories c ON s.category_id = c.category_id";
		
		return result_AllList(sql);
	}
	
	
	public ArrayList<ListBean> searchResult(HttpServletRequest request){
		String sql = "select * from sales s "
				+ "LEFT JOIN accounts a ON s.account_id = a.account_id "
				+ "LEFT JOIN categories c ON s.category_id = c.category_id ";
		
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String account = request.getParameter("account_id");
		String category = request.getParameter("category_id");
		String trade = request.getParameter("trade_name");
		String note = request.getParameter("note");
		sql += "where sale_date >= '"+ date1 +"' ";
		if (!date2.isEmpty())
			sql += "and sale_date <= '"+ date2 +"' ";
		if (!account.isEmpty())
			sql += "and account_id = '"+ account +"' ";
		if (!category.isEmpty())
			sql += "and category_id = '"+ category +"' ";
		sql += "and trade_name like '%"+ trade +"%' ";
		sql += "and note like '%"+ note+"%' ";
		
		
		return result_AllList(sql);
		
	}
	
	
	
	
	
	ArrayList<ListBean> result_AllList(String sql) {
		ArrayList<ListBean> list = new ArrayList<>();
		
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ListBean sales = new ListBean(
						rs.getInt("sale_id"), 
						CommonUtil.str_LocalDate(rs.getString("sale_date") ), 
						rs.getInt("account_id"), 
						rs.getInt("category_id"), 
						rs.getString("trade_name"), 
						rs.getInt("unit_price"), 
						rs.getInt("sale_number"), 
						rs.getString("note"),
						rs.getString("name"),
						rs.getString("category_name")
						);
				list.add(sales);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void salesUpdate(HttpServletRequest request) {
		SaleService_2 s2 = new SaleService_2();
		try {
			s2.salesupdate(request.getParameter("sale_date"), 
					CommonUtil.str_Int(request.getParameter("account_id")), 
					CommonUtil.str_Int(request.getParameter("category_id")), 
					request.getParameter("trade_name"), 
					CommonUtil.str_Int(request.getParameter("unit_price")), 
					CommonUtil.str_Int(request.getParameter("sale_number")), 
					request.getParameter("note"), 
					CommonUtil.str_Int(request.getParameter("sale_id")) 
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
