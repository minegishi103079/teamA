package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.beans.SalesBean;
import util.CommonUtil;
import util.DbUtil;

public class SalesService {
	
	
	public ArrayList<SalesBean> selectAll() {
		String sql = "select * from sales";
		
		return result_list(sql);
		
	}
	
	public SalesBean detailSale(String sales_id) {
		String sql = "select * from sales where sales_id = ?";
		SalesBean sales = null;
		
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setString(1, sales_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			sales = new SalesBean(
				rs.getInt("sale_id"), 
				CommonUtil.str_LocalDate(rs.getString("sale_date") ), 
				rs.getInt("account_id"), 
				rs.getInt("category_id"), 
				rs.getString("trade_name"), 
				rs.getInt("unit_price"), 
				rs.getInt("sale_number"), 
				rs.getString("note"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sales;
	}
	
	
	
	
	
	ArrayList<SalesBean> result_list(String sql) {
		ArrayList<SalesBean> salelist = new ArrayList<>();
		
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SalesBean sales = new SalesBean(
						rs.getInt("sale_id"), 
						CommonUtil.str_LocalDate(rs.getString("sale_date") ), 
						rs.getInt("account_id"), 
						rs.getInt("category_id"), 
						rs.getString("trade_name"), 
						rs.getInt("unit_price"), 
						rs.getInt("sale_number"), 
						rs.getString("note"));
				salelist.add(sales);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salelist;
	}
	
	
	
}
