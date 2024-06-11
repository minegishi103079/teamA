package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.beans.ListBean;
import util.CommonUtil;
import util.DbUtil;

public class SalesService {
	
	public static void main(String[] args) {
		
		String str = "rt";
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
						rs.getInt("authority"), 
						rs.getString("category_name"),
						rs.getInt("active_flg")
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
		+ "LEFT JOIN categories c ON s.category_id = c.category_id;";
		
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
						rs.getInt("authority"), 
						rs.getString("category_name"),
						rs.getInt("active_flg")
						);
				list.add(sales);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
