package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DbUtil;

public class SaleService_2 {
	//売上追加
	public void salesinsert(String da,int ai,int ci,String tn,int up,int sn,String n) {
		String sql = "INSERT into sales(sale_date,account_id,category_id,trade_name,unit_price,sale_number,note) VALUES(?,?,?,?,?,?,?)";
		try(Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, da);
			ps.setInt(2, ai);
			ps.setInt(3, ci);
			ps.setString(4, tn);
			ps.setInt(5, up);
			ps.setInt(6, sn);
			ps.setString(7, n);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//売上更新
	public void salesupdate(String da,int ai,int ci,String tn,int up,int sn,String n,int si) {
		String sql = "update sales set sale_date=?,account_id=?,category_id=?,trade_name=?,unit_price=?,sale_number=?,note=? where sale_id=?";
		try(Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, da);
			ps.setInt(2, ai);
			ps.setInt(3, ci);
			ps.setString(4, tn);
			ps.setInt(5, up);
			ps.setInt(6, sn);
			ps.setString(7, n);
			ps.setInt(8, si);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//売上削除
	public void salesdelete(String da,int ai,int ci,String tn,int up,int sn,String n) {
		String sql = "delete from sales where sales_id = ?";
		try(Connection conn = DbUtil.open();
				PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, da);
			ps.setInt(2, ai);
			ps.setInt(3, ci);
			ps.setString(4, tn);
			ps.setInt(5, up);
			ps.setInt(6, sn);
			ps.setString(7, n);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
