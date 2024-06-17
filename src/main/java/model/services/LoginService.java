package model.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.beans.AccountsBean;
import util.DbUtil;

public class LoginService {
	
	public static AccountsBean logincheck(String m,String p) {
		String sql = "SELECT * FROM accounts where mail = ? and password = ?";
		AccountsBean reslut=null;
		
		try(Connection conn = DbUtil.open();
			PreparedStatement ps = conn.prepareStatement(sql);){
			
			
			ps.setString(1, m);
			ps.setString(2, p);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				reslut = new AccountsBean();
				reslut.setAccount_id(rs.getInt("account_id"));
				reslut.setMail(rs.getString("mail"));
				reslut.setName(rs.getString("name"));
				reslut.setPassword(rs.getString("password"));
				reslut.setAuthority(rs.getString("authority"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reslut;
	}

}
