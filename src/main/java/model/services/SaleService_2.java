package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DbUtil;

public class SaleService_2 {
	
	public void salesinsert(String da,int ai,int ci,String tn,int up,int sn,String n) {
		String sql = "INSERT into sales(sale_date,account_id,categpry_id,trade_name,unit_price,sale_number,note) VALUES(?,?,?,?,?,?,?)";
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
